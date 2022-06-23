package com.demo.BookMyShowDemo.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="tier")
public class Tier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;
}
