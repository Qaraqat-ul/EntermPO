package com.example.cinema.hub.service.impl;

import com.example.cinema.hub.dto.CinemaDTO;
import com.example.cinema.hub.entity.Cinema;
import com.example.cinema.hub.mapper.CinemaMapper;
import com.example.cinema.hub.repository.CinemaRepository;
import com.example.cinema.hub.service.CinemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CinemaServiceImpl implements CinemaService {

    private final CinemaRepository cinemaRepository;
    private final CinemaMapper cinemaMapper;

    @Override
    public List<CinemaDTO> getAll() {
        return cinemaMapper.toDtoList(cinemaRepository.findAll());
    }

    @Override
    public CinemaDTO getById(Long id) {
        Cinema cinema = cinemaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cinema not found"));
        return cinemaMapper.toDto(cinema);
    }

    @Override
    public CinemaDTO create(CinemaDTO dto) {
        Cinema cinema = cinemaMapper.toEntity(dto);
        Cinema saved = cinemaRepository.save(cinema);
        return cinemaMapper.toDto(saved);
    }

    @Override
    public CinemaDTO update(Long id, CinemaDTO dto) {
        Cinema cinema = cinemaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cinema not found"));

        cinema.setName(dto.getName());
        cinema.setAddress(dto.getAddress());
        cinema.setCity(dto.getCity());

        Cinema saved = cinemaRepository.save(cinema);
        return cinemaMapper.toDto(saved);
    }

    @Override
    public void delete(Long id) {
        cinemaRepository.deleteById(id);
    }
}

