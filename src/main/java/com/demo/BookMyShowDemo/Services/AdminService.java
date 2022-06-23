package com.demo.BookMyShowDemo.Services;


import com.demo.BookMyShowDemo.Entity.*;
import com.demo.BookMyShowDemo.Repository.*;
import com.demo.BookMyShowDemo.Requests.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Service
public class AdminService{



    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private  ScreenRepository screenRepository;

    @Autowired
    private MovieScheduleRepository movieScheduleRepository;

    @Autowired
    private TierRepository tierRepository;

    @Autowired
    private  SeatRepository seatRepository;

    @Autowired
    private BookingRequestRepository bookingRequestRepository;



   public MovieRequest addNewMovie(MovieRequest movieRequest){
       try{
           Movie movie=new Movie();
           movie.setName(movieRequest.getName());
           movie.setLanguage(movieRequest.getLanguage());
           movie.setDuration(movieRequest.getDuration());
           movie=movieRepository.save(movie);
           log.println("new movie added "+movie);

       }catch(Exception ex){
           log.println("error while adding new movie "+movieRequest);
           log.println("error "+ex);
       }
       return movieRequest;
   }
    public Movie updateMovie(int movieId,Movie movieRequest){
        try{
            Optional<Movie> findByMovie=movieRepository.findById(movieId);
            if(!findByMovie.isPresent()){
                throw new RuntimeException("Invalid MovieId");
            }else {
                movieRequest.setId(movieId);
                movieRepository.save(movieRequest);
                log.println("new movie added " + movieRequest);
            }
        }catch(Exception ex){
            log.println("error while adding new movie "+movieRequest);
            log.println("error "+ex);
        }
        return movieRequest;
    }


   public TheaterRequest addNewTheater(TheaterRequest theaterRequest) {
       try{
           Theater theater=new Theater();
           theater.setName(theaterRequest.getName());
           theater.setNoOfScreens(theaterRequest.getNoOfScreens());
           Address address=theaterRequest.getAddress();
           address=addressRepository.save(address);
           theater.setAddress(address);
          theaterRepository.save(theater);

       }catch(Exception ex){

           log.println("error while adding new Theater");
           log.println("error "+ex);
       }
       return theaterRequest;
   }

   public ScreenRequest addNewScreen(ScreenRequest screenRequest){
       Theater theater=theaterRepository.findById(screenRequest.getTheaterId()).orElse(null);
       try {
           if(theater == null) {
               throw new RuntimeException("Invalid theater id " + screenRequest.getTheaterId());
           }else {
               Screen screen = new Screen();
               screen.setType(screenRequest.getScreenType());
               screen.setTheater(theater);
               screenRepository.save(screen);
           }
       }catch(Exception ex){
           log.println("error while adding new screen");
           log.println("error "+ex);
       }
       return screenRequest;
   }

   public NewMovieScheduleRequest addNewMovieSchedule(NewMovieScheduleRequest newMovieScheduleRequest){
       MovieSchedule movieSchedule=new MovieSchedule();
       try{
           Movie movie=movieRepository.findById(newMovieScheduleRequest.getMovieId()).orElse(null);
           Theater theater=theaterRepository.findById(newMovieScheduleRequest.getTheaterId()).orElse(null);
           Screen screen=screenRepository.findById(newMovieScheduleRequest.getScreenId()).orElse(null);
           if(movie == null || theater == null || screen == null){
               throw new RuntimeException("Invalid given id");
           }
           movieSchedule.setMovie(movie);
           movieSchedule.setTheater(theater);
           movieSchedule.setScreen(screen);
           movieSchedule.setStartTime(newMovieScheduleRequest.getStartTime());
           movieSchedule.setEndTime(newMovieScheduleRequest.getEndTime());
           movieScheduleRepository.save(movieSchedule);

       }catch(Exception ex){
           log.println("error while adding movie schedule");
           log.println("error "+ex);
       }
       return newMovieScheduleRequest;
   }

   public ScreenLayoutRequest addScreenLayout(ScreenLayoutRequest screenLayoutRequest){
       try{
           Screen screen=screenRepository.findById(screenLayoutRequest.getScreenId()).orElse(null);
           if(screen == null){
               throw new Exception("invalid screen id");
           }

           for(ScreenLayoutRequest.TierDetails tierDetails : screenLayoutRequest.getTierDetailsList()){
               Tier tier=new Tier();
               tier.setName(tierDetails.getTierName());
               tier.setPrice(tierDetails.getTierPrice());
               tier.setScreen(screen);
               tierRepository.save(tier);
               for(int i=0; i<tierDetails.getNoOfSeats(); i++){
                    Seat seat=new Seat();
                    seat.setScreen(screen);
                    seat.setTier(tier);
                    seat.setStatus(Seat.Status.EMPTY);
                    seatRepository.save(seat);
               }
           }

       }catch (Exception ex){
           log.println("error while adding screen layout");
           log.println("error "+ex);
       }
       return screenLayoutRequest;
   }

    public Tier updateScreenTierByScreenId(int tierId,int screenId,Tier tierRequest){
        try{
           Tier tier=tierRepository.findById(tierId).orElse(null);
           Screen screen=screenRepository.findById(screenId).orElse(null);

            if(screen == null || tier == null){
                throw new Exception("invalid screen id or tierId");
            }else {
                    Tier tiers = new Tier();
                    tiers.setId(tierId);
                    tiers.setName(tierRequest.getName());
                    tiers.setScreen(screen);
                    tiers.setPrice(tierRequest.getPrice());
                    tierRepository.save(tier);

            }
        }catch (Exception ex){
            log.println("error while adding screen layout");
            log.println("error "+ex);
        }
        return tierRequest;
    }

    public Iterable<BookingRequest> getAllBookings(){
        Iterable<BookingRequest> bookings=bookingRequestRepository.findAll();
      return bookings;
    }

    public  String unLockSeats(int screenId){
       Optional<Screen> screen=screenRepository.findById(screenId);
       if(!screen.isPresent()){
           throw new RuntimeException("invalid screenId");
       }else{
           seatRepository.unLockSeats(screenId);
           return "Status updated";
       }

    }
}
