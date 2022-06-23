package com.demo.BookMyShowDemo.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class NewBookingRequest {

    private int userId;
    private int movieScheduleId;
    private int seatId;
}
