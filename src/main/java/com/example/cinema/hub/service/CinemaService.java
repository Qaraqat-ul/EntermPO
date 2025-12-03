package com.example.cinema.hub.service;

import com.example.cinema.hub.dto.CinemaDTO;

import java.util.List;

public interface CinemaService {

    List<CinemaDTO> getAll();

    CinemaDTO getById(Long id);

    CinemaDTO create(CinemaDTO dto);

    CinemaDTO update(Long id, CinemaDTO dto);

    void delete(Long id);
}
