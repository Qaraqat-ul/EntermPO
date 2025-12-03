package com.example.cinema.hub.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cinema")
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String city;
}
