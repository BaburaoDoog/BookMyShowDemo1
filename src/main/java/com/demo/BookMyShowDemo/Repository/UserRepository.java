package com.demo.BookMyShowDemo.Repository;


import com.demo.BookMyShowDemo.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {

//    List<User> getAllEmailId(String email);
}
