package com.demo.BookMyShowDemo.Repository;


import com.demo.BookMyShowDemo.Entity.Theater;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TheaterRepository extends CrudRepository<Theater,Integer> {
   // List<Theater> findAllByTheaterId(Integer theaterId);
}
