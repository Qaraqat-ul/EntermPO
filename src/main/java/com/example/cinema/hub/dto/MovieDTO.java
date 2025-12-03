package com.example.cinema.hub.dto;

import lombok.Data;

import java.util.List;

@Data
public class MovieDTO {

    private Long id;
    private String title;
    private Integer durationMinutes;
    private String ageRating;
    private String description;
    private Integer releaseYear;

    private Long cinemaId;
    private List<Long> genreIds;
}

