package com.demo.BookMyShowDemo.Repository;


import com.demo.BookMyShowDemo.Entity.BookingRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingRequestRepository extends CrudRepository<BookingRequest,Integer> {

    @Query("FROM BookingRequest book where book.user.email =:email")
    List<BookingRequest> getByEmailId(@Param("email")String email);
}
