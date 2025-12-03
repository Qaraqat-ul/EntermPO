package com.example.cinema.hub.mapper;

import com.example.cinema.hub.dto.GenreDTO;
import com.example.cinema.hub.entity.Genre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GenreMapperTest {

    @Autowired
    private GenreMapper genreMapper;

    @Test
    void convertEntityToDtoTest() {
        Genre genre = new Genre();
        genre.setId(1L);
        genre.setName("Action");

        GenreDTO dto = genreMapper.toDto(genre);

        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getName());

        Assertions.assertEquals(genre.getId(), dto.getId());
        Assertions.assertEquals(genre.getName(), dto.getName());
    }

    @Test
    void convertDtoToEntityTest() {
        GenreDTO dto = new GenreDTO();
        dto.setId(2L);
        dto.setName("Comedy");

        Genre genre = genreMapper.toEntity(dto);

        Assertions.assertNotNull(genre);
        Assertions.assertNotNull(genre.getId());
        Assertions.assertNotNull(genre.getName());

        Assertions.assertEquals(dto.getId(), genre.getId());
        Assertions.assertEquals(dto.getName(), genre.getName());
    }
}
