package com.demo.BookMyShowDemo.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
public class ScreenLayoutRequest {

    private int screenId;

    private List<TierDetails> tierDetailsList;

    @Data
    @AllArgsConstructor
    @ToString
    @NoArgsConstructor
    public static class TierDetails{

        private String tierName;
        private int tierPrice;
        private int noOfSeats;
    }
}
