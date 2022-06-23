package com.demo.BookMyShowDemo.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class UserRequest {

    private String name;
    private String email;

}
