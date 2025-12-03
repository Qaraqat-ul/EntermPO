package com.example.cinema.hub.mapper;

import com.example.cinema.hub.dto.MovieDTO;
import com.example.cinema.hub.entity.Cinema;
import com.example.cinema.hub.entity.Genre;
import com.example.cinema.hub.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Mapping(source = "cinema", target = "cinemaId")
    @Mapping(source = "genres", target = "genreIds")
    MovieDTO toDto(Movie movie);

    @Mapping(source = "cinemaId", target = "cinema")
    @Mapping(source = "genreIds", target = "genres")
    Movie toEntity(MovieDTO dto);

    default Cinema mapCinema(Long id) {
        if (id == null) return null;
        Cinema cinema = new Cinema();
        cinema.setId(id);
        return cinema;
    }

    default Long mapCinema(Cinema cinema) {
        return cinema != null ? cinema.getId() : null;
    }

    default Genre mapGenre(Long id) {
        if (id == null) return null;
        Genre genre = new Genre();
        genre.setId(id);
        return genre;
    }

    default Long mapGenre(Genre genre) {
        return genre != null ? genre.getId() : null;
    }
}
