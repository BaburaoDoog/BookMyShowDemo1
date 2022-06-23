package com.demo.BookMyShowDemo.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class AddressRequest {

    private String streetAddress;
    private String city;
    private String state;
    private String pinCode;
}
