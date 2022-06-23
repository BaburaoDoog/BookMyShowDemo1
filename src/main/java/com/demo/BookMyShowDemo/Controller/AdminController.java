package com.demo.BookMyShowDemo.Controller;


import com.demo.BookMyShowDemo.Entity.*;
import com.demo.BookMyShowDemo.Requests.*;
import com.demo.BookMyShowDemo.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;



    @PostMapping("addmovie")
    public ResponseEntity addNewMovie(@RequestBody MovieRequest movieRequest){
        return new ResponseEntity(adminService.addNewMovie(movieRequest), HttpStatus.OK);
    }


    @PostMapping("addtheater")
    public ResponseEntity addNewTheater(@RequestBody TheaterRequest theaterRequest){
        return new ResponseEntity(adminService.addNewTheater(theaterRequest), HttpStatus.OK);
    }

    @PostMapping("addscreen")
    public ResponseEntity addNewScreen(@RequestBody ScreenRequest screenRequest){
        return new ResponseEntity(adminService.addNewScreen(screenRequest), HttpStatus.OK);
    }

    @PostMapping("addMovieSchedule")
    public ResponseEntity addMovieSchedule(@RequestBody NewMovieScheduleRequest newMovieScheduleRequest){
        return new ResponseEntity(adminService.addNewMovieSchedule(newMovieScheduleRequest), HttpStatus.OK);
    }


    @PostMapping("addScreenLayout")
    public ResponseEntity addScreenLayout(@RequestBody ScreenLayoutRequest screenLayoutRequest){
        return new ResponseEntity(adminService.addScreenLayout(screenLayoutRequest), HttpStatus.OK);
    }

    @PutMapping("updateScreenLayout/{id}/{screenId}")
    public ResponseEntity updateScreenLayout(@PathVariable("id")int id,@PathVariable("screenId")int screenId,@RequestBody Tier tier){
        return new ResponseEntity(adminService.updateScreenTierByScreenId(id,screenId,tier), HttpStatus.OK);
    }

    @GetMapping("getBookings")
    public Iterable<BookingRequest> getAllBookings(){
        return adminService.getAllBookings();
    }




    @PutMapping("unLockSeats/{screenId}")
    public ResponseEntity unlockSeats(@PathVariable("screenId")int screenId){
        return new ResponseEntity<>(adminService.unLockSeats(screenId),HttpStatus.OK);
    }

    @PutMapping("updateMovie/{movieId}")
    public ResponseEntity updateMovie(@PathVariable("movieId")int movieId, Movie movieRequest){
        return new ResponseEntity<>(adminService.updateMovie(movieId,movieRequest),HttpStatus.OK);
    }
}
