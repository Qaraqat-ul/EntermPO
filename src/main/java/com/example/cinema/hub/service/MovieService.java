package com.example.cinema.hub.service;

import com.example.cinema.hub.dto.MovieDTO;

import java.util.List;

public interface MovieService {

    List<MovieDTO> getAll();

    MovieDTO getById(Long id);

    MovieDTO create(MovieDTO dto);

    MovieDTO update(Long id, MovieDTO dto);

    void delete(Long id);
}
