package com.example.cinema.hub.service;

import com.example.cinema.hub.dto.CinemaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
class CinemaServiceTest {

    @Autowired
    private CinemaService cinemaService;

    @Test
    void getAllTest() {

        List<CinemaDTO> list = cinemaService.getAll();

        Assertions.assertNotNull(list);
        Assertions.assertNotEquals(0, list.size());

        for (CinemaDTO dto : list) {
            Assertions.assertNotNull(dto);
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getName());
            Assertions.assertNotNull(dto.getAddress());
            Assertions.assertNotNull(dto.getCity());
        }
    }

    @Test
    void getByIdTest() {

        List<CinemaDTO> list = cinemaService.getAll();

        Assertions.assertNotNull(list);
        Assertions.assertNotEquals(0, list.size());

        Random random = new Random();
        int randomIndex = random.nextInt(list.size());
        Long someId = list.get(randomIndex).getId();

        CinemaDTO dto = cinemaService.getById(someId);

        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getName());
        Assertions.assertNotNull(dto.getAddress());
        Assertions.assertNotNull(dto.getCity());
    }
}

