package com.example.cinema.hub.mapper;

import com.example.cinema.hub.dto.MovieDTO;
import com.example.cinema.hub.entity.Cinema;
import com.example.cinema.hub.entity.Genre;
import com.example.cinema.hub.entity.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MovieMapperTest {

    @Autowired
    private MovieMapper movieMapper;

    @Test
    void convertEntityToDtoTest() {
        Cinema cinema = new Cinema();
        cinema.setId(1L);
        cinema.setName("Chaplin Mega");

        Genre g1 = new Genre();
        g1.setId(1L);
        g1.setName("Action");

        Genre g2 = new Genre();
        g2.setId(2L);
        g2.setName("Comedy");

        Movie movie = new Movie();
        movie.setId(10L);
        movie.setTitle("Test Movie");
        movie.setDurationMinutes(120);
        movie.setAgeRating("16+");
        movie.setDescription("Some description");
        movie.setReleaseYear(2020);
        movie.setCinema(cinema);
        movie.setGenres(Arrays.asList(g1, g2));

        MovieDTO dto = movieMapper.toDto(movie);

        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getTitle());
        Assertions.assertNotNull(dto.getAgeRating());
        Assertions.assertNotNull(dto.getDurationMinutes());
        Assertions.assertNotNull(dto.getReleaseYear());
        Assertions.assertNotNull(dto.getCinemaId());
        Assertions.assertNotNull(dto.getGenreIds());

        Assertions.assertEquals(movie.getId(), dto.getId());
        Assertions.assertEquals(movie.getTitle(), dto.getTitle());
        Assertions.assertEquals(movie.getAgeRating(), dto.getAgeRating());
        Assertions.assertEquals(movie.getDurationMinutes(), dto.getDurationMinutes());
        Assertions.assertEquals(movie.getReleaseYear(), dto.getReleaseYear());
        Assertions.assertEquals(movie.getCinema().getId(), dto.getCinemaId());

        List<Long> genreIds = dto.getGenreIds();
        Assertions.assertEquals(2, genreIds.size());
        Assertions.assertTrue(genreIds.contains(1L));
        Assertions.assertTrue(genreIds.contains(2L));
    }

    @Test
    void convertDtoToEntityTest() {
        MovieDTO dto = new MovieDTO();
        dto.setId(20L);
        dto.setTitle("Dto Movie");
        dto.setDurationMinutes(130);
        dto.setAgeRating("12+");
        dto.setDescription("Dto description");
        dto.setReleaseYear(2021);
        dto.setCinemaId(1L);
        dto.setGenreIds(Arrays.asList(1L, 3L));

        Movie movie = movieMapper.toEntity(dto);

        Assertions.assertNotNull(movie);
        Assertions.assertNotNull(movie.getId());
        Assertions.assertNotNull(movie.getTitle());
        Assertions.assertNotNull(movie.getAgeRating());
        Assertions.assertNotNull(movie.getDurationMinutes());
        Assertions.assertNotNull(movie.getReleaseYear());
        Assertions.assertNotNull(movie.getCinema());
        Assertions.assertNotNull(movie.getGenres());

        Assertions.assertEquals(dto.getId(), movie.getId());
        Assertions.assertEquals(dto.getTitle(), movie.getTitle());
        Assertions.assertEquals(dto.getAgeRating(), movie.getAgeRating());
        Assertions.assertEquals(dto.getDurationMinutes(), movie.getDurationMinutes());
        Assertions.assertEquals(dto.getReleaseYear(), movie.getReleaseYear());
        Assertions.assertEquals(dto.getCinemaId(), movie.getCinema().getId());

        List<Genre> genres = movie.getGenres();
        Assertions.assertEquals(2, genres.size());
        Assertions.assertEquals(dto.getGenreIds().get(0), genres.get(0).getId());
        Assertions.assertEquals(dto.getGenreIds().get(1), genres.get(1).getId());
    }
}

