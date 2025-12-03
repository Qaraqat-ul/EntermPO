package com.example.cinema.hub.service;

import com.example.cinema.hub.dto.GenreDTO;

import java.util.List;

public interface GenreService {

    List<GenreDTO> getAll();

    GenreDTO getById(Long id);

    GenreDTO create(GenreDTO dto);

    GenreDTO update(Long id, GenreDTO dto);

    void delete(Long id);
}
