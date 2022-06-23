package com.demo.BookMyShowDemo.Repository;


import com.demo.BookMyShowDemo.Entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address,Integer> {
}
