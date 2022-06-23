package com.demo.BookMyShowDemo.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="movie_schedule",uniqueConstraints = @UniqueConstraint(columnNames = {"movie_id","screen_id"}))
public class MovieSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

    @Column(name="start_time")
    private String startTime;

    @Column(name="end_time")
    private String endTime;
}
