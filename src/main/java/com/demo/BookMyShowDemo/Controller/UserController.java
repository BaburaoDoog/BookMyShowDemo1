package com.demo.BookMyShowDemo.Controller;

import com.demo.BookMyShowDemo.Entity.BookingRequest;
import com.demo.BookMyShowDemo.Entity.MovieSchedule;
import com.demo.BookMyShowDemo.Entity.Seat;
import com.demo.BookMyShowDemo.Requests.NewBookingRequest;
import com.demo.BookMyShowDemo.Requests.UserRequest;
import com.demo.BookMyShowDemo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("adduser")
    public ResponseEntity addNewUser(@RequestBody UserRequest userRequest){
        return new ResponseEntity("status : "+userService.newUser(userRequest), HttpStatus.OK);
    }

    @PutMapping("user/{id}")
    public ResponseEntity updateUser(@PathVariable("id")int id,@RequestBody UserRequest userRequest){
        return new ResponseEntity("status : "+userService.updateUser(id,userRequest), HttpStatus.OK);
    }

    @GetMapping("allMovies")
    public List<MovieSchedule> listOfMoviesSchedule(){
        return userService.listOfMoviesSchedule();
    }

    @GetMapping("allScreenLayout")
    public List<Seat> listOfSeatLayout(){
        return userService.listOfSeatLayout();
    }

    @GetMapping("getAllByScreenAndTier/{screenId}/{tierId}")
    public List<Seat> listOfSeatLayoutByScreenIdAndTheaterId(@PathVariable("screenId")int screenId,
                                                             @PathVariable("tierId")int tierId){
        return userService.listAllSeatLayoutByScreenIdAndTheaterId(screenId,tierId);
    }

    @PostMapping("bookSeat")
    public ResponseEntity<String> bookSeat(@RequestBody NewBookingRequest newBookingRequest){
        return new ResponseEntity<>("status : "+userService.booking(newBookingRequest), HttpStatus.OK);
    }

    @GetMapping("booking/{email}")
    public ResponseEntity<List<BookingRequest>> getBookingStatusByEmailId(@PathVariable("email")String email){
        return new ResponseEntity<>(userService.getBookingStatusByEmailId(email),HttpStatus.OK);
    }
}
