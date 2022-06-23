package com.demo.BookMyShowDemo.Requests;


import com.demo.BookMyShowDemo.Entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class TheaterRequest {

    private String name;
    private int noOfScreens;
    private Address address;

}
