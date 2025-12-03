package com.example.cinema.hub.service.impl;

import com.example.cinema.hub.dto.GenreDTO;
import com.example.cinema.hub.entity.Genre;
import com.example.cinema.hub.mapper.GenreMapper;
import com.example.cinema.hub.repository.GenreRepository;
import com.example.cinema.hub.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    @Override
    public List<GenreDTO> getAll() {
        return genreMapper.toDtoList(genreRepository.findAll());
    }

    @Override
    public GenreDTO getById(Long id) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genre not found"));
        return genreMapper.toDto(genre);
    }

    @Override
    public GenreDTO create(GenreDTO dto) {
        Genre genre = genreMapper.toEntity(dto);
        Genre saved = genreRepository.save(genre);
        return genreMapper.toDto(saved);
    }

    @Override
    public GenreDTO update(Long id, GenreDTO dto) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genre not found"));

        genre.setName(dto.getName());

        Genre saved = genreRepository.save(genre);
        return genreMapper.toDto(saved);
    }

    @Override
    public void delete(Long id) {
        genreRepository.deleteById(id);
    }
}
