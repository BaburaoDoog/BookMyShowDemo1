package com.demo.BookMyShowDemo.Repository;


import com.demo.BookMyShowDemo.Entity.Seat;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

public interface SeatRepository extends CrudRepository<Seat,Integer> {

    List<Seat> findAllByScreenIdAndTierId(Integer screenId,Integer tier);

//    @Query("FROM Seat seats where seats.screen.id =:screenId and seats.status ='BOOKED'")
//    Optional<Seat> findAllSeatsByScreenId(@Param("screenId") Integer screenId);

    @Transactional
    @Modifying
    @Query("update Seat seat set seat.status ='EMPTY' where seat.screen.id =:screenId and seat.status ='BOOKED'")
    void unLockSeats(@Param("screenId")Integer screenId);

}
