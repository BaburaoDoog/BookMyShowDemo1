package com.demo.BookMyShowDemo.Repository;


import com.demo.BookMyShowDemo.Entity.Tier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TierRepository extends CrudRepository<Tier,Integer> {

    @Query("FROM Tier tier where tier.screen.id =:screenId")
    List<Tier> TierDetailsByScreenId(@Param("screenId")int screenId);
}
