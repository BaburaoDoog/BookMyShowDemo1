package com.demo.BookMyShowDemo.Requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@ToString
public class ScreenRequest {

    private String screenType;
    private int theaterId;
}
