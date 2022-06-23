package com.demo.BookMyShowDemo.Repository;


import com.demo.BookMyShowDemo.Entity.Movie;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie,Integer>{
}
