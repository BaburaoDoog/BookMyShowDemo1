package com.demo.BookMyShowDemo.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Date;


@Data
@AllArgsConstructor
@ToString
public class NewMovieScheduleRequest {

private Integer movieId;

private Integer screenId;

private Integer theaterId;

private String startTime;

private String endTime;
}
