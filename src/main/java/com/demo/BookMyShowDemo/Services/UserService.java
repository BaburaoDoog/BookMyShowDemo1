package com.demo.BookMyShowDemo.Services;

import com.demo.BookMyShowDemo.Entity.*;
import com.demo.BookMyShowDemo.Repository.*;
import com.demo.BookMyShowDemo.Requests.NewBookingRequest;
import com.demo.BookMyShowDemo.Requests.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Service
public class UserService {

    @Autowired
    private MovieScheduleRepository movieScheduleRepository;


    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRequestRepository bookingRequestRepository;

    public UserRequest newUser(UserRequest userRequest){
        try{
            User user=new User();
            user.setName(userRequest.getName());
            user.setEmail(userRequest.getEmail());
            userRepository.save(user);
        }catch (Exception ex){
            log.println("error while adding new User");
            log.println("error "+ex);
        }
        log.print("new user added");
        return userRequest;
    }
    public User adduser(User user){
       return userRepository.save(user);
    }

    public UserRequest updateUser(int id,UserRequest userRequest){
        try{
            User user=new User();
            user.setId(id);
            user.setName(userRequest.getName());
            user.setEmail(userRequest.getEmail());
            userRepository.save(user);
        }catch (Exception ex){
            log.println("error while adding new User");
            log.println("error "+ex);
        }
        log.print("new user added");
        return userRequest;
    }

    public List<MovieSchedule> listOfMoviesSchedule(){
        List<MovieSchedule> movieSchedules= (List<MovieSchedule>) movieScheduleRepository.findAll();
        return movieSchedules;
    }

    public List<Seat> listOfSeatLayout(){
        List<Seat> seatLayout= (List<Seat>) seatRepository.findAll();
        return seatLayout;
    }

    public List<Seat> listAllSeatLayoutByScreenIdAndTheaterId(int screenId, int tierId) {
        Seat screenId1 = seatRepository.findById(screenId).orElse(null);
        Seat tierId1 = seatRepository.findById(tierId).orElse(null);
        List<Seat> screenAndTheaterSeatLayout;
        if (screenId1 == null || tierId1 == null) {
            throw new RuntimeException("Invalid screenId or theaterId");
        } else {
            screenAndTheaterSeatLayout= seatRepository.findAllByScreenIdAndTierId(screenId,tierId);
        }
        return screenAndTheaterSeatLayout;
    }

    public NewBookingRequest booking(NewBookingRequest newBookingRequest){
        User userId=userRepository.findById(newBookingRequest.getUserId()).orElse(null);
        MovieSchedule movieScheduleId=movieScheduleRepository.findById(newBookingRequest.getMovieScheduleId()).orElse(null);
        Seat seatId=seatRepository.findById(newBookingRequest.getSeatId()).orElse(null);


        if(Objects.isNull(userId) || Objects.isNull(movieScheduleId)){
            throw new RuntimeException("given id's are not found");
        }else if(seatId.getStatus().equals(Seat.Status.BOOKED)){
            throw new RuntimeException("This seat is already booked");
       }else{
            BookingRequest bookingRequest=new BookingRequest();
            bookingRequest.setUser(userId);
            bookingRequest.setMovieSchedule(movieScheduleId);
            bookingRequest.setSeat(seatId);
            bookingRequest.setBookingStatus(BookingRequest.PaymentStatus.PAYMENT_PENDING);
            bookingRequestRepository.save(bookingRequest);
            Seat seat=new Seat();
            Optional<Seat> seats=seatRepository.findById(newBookingRequest.getSeatId());
            seat.setId(newBookingRequest.getSeatId());
            seat.setScreen(seats.get().getScreen());
            seat.setTier(seats.get().getTier());
            seat.setStatus(Seat.Status.BOOKED);
            seatRepository.save(seat);
        }
        return newBookingRequest;
}

    public List<BookingRequest> getBookingStatusByEmailId(String emailId){
      List<BookingRequest> bookingRequests=bookingRequestRepository.getByEmailId(emailId);
        return bookingRequests;
    }
}
