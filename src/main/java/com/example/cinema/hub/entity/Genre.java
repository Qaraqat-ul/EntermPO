package com.example.cinema.hub.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
