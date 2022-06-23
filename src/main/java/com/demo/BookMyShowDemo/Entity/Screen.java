package com.demo.BookMyShowDemo.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="screen")
public class Screen {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="type")
    private String Type;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;
}
