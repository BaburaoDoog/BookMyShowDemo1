package com.demo.BookMyShowDemo.Repository;


import com.demo.BookMyShowDemo.Entity.MovieSchedule;
import org.springframework.data.repository.CrudRepository;

public interface MovieScheduleRepository extends CrudRepository<MovieSchedule,Integer> {
}
