package com.example.cinema.hub.service;

import com.example.cinema.hub.dto.MovieDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@SpringBootTest
@Transactional
class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @Test
    void getAllTest() {

        List<MovieDTO> list = movieService.getAll();

        Assertions.assertNotNull(list);
        Assertions.assertNotEquals(0, list.size());

        for (MovieDTO dto : list) {
            Assertions.assertNotNull(dto);
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getTitle());
            Assertions.assertNotNull(dto.getAgeRating());
            Assertions.assertNotNull(dto.getDurationMinutes());
            Assertions.assertNotNull(dto.getReleaseYear());
            Assertions.assertNotNull(dto.getCinemaId());

        }
    }

    @Test
    void getByIdTest() {

        List<MovieDTO> list = movieService.getAll();

        Assertions.assertNotNull(list);
        Assertions.assertNotEquals(0, list.size());

        Random random = new Random();
        int randomIndex = random.nextInt(list.size());
        Long someId = list.get(randomIndex).getId();

        MovieDTO dto = movieService.getById(someId);

        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getTitle());
        Assertions.assertNotNull(dto.getAgeRating());
        Assertions.assertNotNull(dto.getDurationMinutes());
        Assertions.assertNotNull(dto.getReleaseYear());
        Assertions.assertNotNull(dto.getCinemaId());







    }
}
