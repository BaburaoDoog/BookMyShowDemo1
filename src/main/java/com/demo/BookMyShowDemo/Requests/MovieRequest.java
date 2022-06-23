package com.demo.BookMyShowDemo.Requests;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class MovieRequest {


    private String name;

    private String language;

    private String duration;
}
