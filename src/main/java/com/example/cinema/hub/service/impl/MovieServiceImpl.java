package com.example.cinema.hub.service.impl;

import com.example.cinema.hub.dto.MovieDTO;
import com.example.cinema.hub.entity.Cinema;
import com.example.cinema.hub.entity.Genre;
import com.example.cinema.hub.entity.Movie;
import com.example.cinema.hub.mapper.MovieMapper;
import com.example.cinema.hub.repository.CinemaRepository;
import com.example.cinema.hub.repository.GenreRepository;
import com.example.cinema.hub.repository.MovieRepository;
import com.example.cinema.hub.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final CinemaRepository cinemaRepository;
    private final GenreRepository genreRepository;
    private final MovieMapper movieMapper;

    @Override
    public List<MovieDTO> getAll() {
        return movieRepository.findAll()
                .stream()
                .map(movieMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public MovieDTO getById(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        return movieMapper.toDto(movie);
    }

    @Override
    public MovieDTO create(MovieDTO dto) {
        Cinema cinema = cinemaRepository.findById(dto.getCinemaId())
                .orElseThrow(() -> new RuntimeException("Cinema not found"));

        List<Genre> genres = genreRepository.findAllById(dto.getGenreIds());

        Movie movie = new Movie();
        movie.setTitle(dto.getTitle());
        movie.setDurationMinutes(dto.getDurationMinutes());
        movie.setAgeRating(dto.getAgeRating());
        movie.setDescription(dto.getDescription());
        movie.setReleaseYear(dto.getReleaseYear());
        movie.setCinema(cinema);
        movie.setGenres(genres);

        Movie saved = movieRepository.save(movie);
        return movieMapper.toDto(saved);
    }

    @Override
    public MovieDTO update(Long id, MovieDTO dto) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        Cinema cinema = cinemaRepository.findById(dto.getCinemaId())
                .orElseThrow(() -> new RuntimeException("Cinema not found"));

        List<Genre> genres = genreRepository.findAllById(dto.getGenreIds());

        movie.setTitle(dto.getTitle());
        movie.setDurationMinutes(dto.getDurationMinutes());
        movie.setAgeRating(dto.getAgeRating());
        movie.setDescription(dto.getDescription());
        movie.setReleaseYear(dto.getReleaseYear());
        movie.setCinema(cinema);
        movie.setGenres(genres);

        Movie saved = movieRepository.save(movie);
        return movieMapper.toDto(saved);
    }

    @Override
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }
}
