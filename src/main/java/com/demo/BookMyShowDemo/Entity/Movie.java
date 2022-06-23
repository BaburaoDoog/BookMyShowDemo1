package com.demo.BookMyShowDemo.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="language")
    private String language;

    @Column(name="duration")
    private String duration;   //duration in minutes



}
