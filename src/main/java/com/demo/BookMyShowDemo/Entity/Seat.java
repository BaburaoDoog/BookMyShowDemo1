package com.demo.BookMyShowDemo.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="seat")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;

    @ManyToOne
    @JoinColumn(name = "tier_id")
    private Tier tier;

    @Column(name = "status", columnDefinition = "enum('BOOKED','EMPTY')")
    @Enumerated(value = EnumType.STRING)
    private Status status;

    public enum Status{
        BOOKED,EMPTY;
    }
}
