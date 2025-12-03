package com.example.cinema.hub.service;

import com.example.cinema.hub.dto.GenreDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
class GenreServiceTest {

    @Autowired
    private GenreService genreService;

    @Test
    void getAllTest() {
        List<GenreDTO> list = genreService.getAll();

        Assertions.assertNotNull(list);
        Assertions.assertNotEquals(0, list.size());

        for (GenreDTO genreDTO : list) {
            Assertions.assertNotNull(genreDTO);
            Assertions.assertNotNull(genreDTO.getId());
            Assertions.assertNotNull(genreDTO.getName());
        }
    }

    @Test
    void getByIdTest() {
        List<GenreDTO> list = genreService.getAll();

        Assertions.assertNotNull(list);
        Assertions.assertNotEquals(0, list.size());

        Random random = new Random();
        int randomIndex = random.nextInt(list.size());
        Long someId = list.get(randomIndex).getId();

        GenreDTO dto = genreService.getById(someId);

        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getName());


    }
}
