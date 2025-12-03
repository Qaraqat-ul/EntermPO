package com.example.cinema.hub.controller;

import com.example.cinema.hub.dto.GenreDTO;
import com.example.cinema.hub.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/genres")
public class GenreController {

    private final GenreService genreService;

    @GetMapping
    public List<GenreDTO> getAll() {
        return genreService.getAll();
    }

    @GetMapping("/{id}")
    public GenreDTO getById(@PathVariable Long id) {
        return genreService.getById(id);
    }

    @PostMapping
    public GenreDTO create(@RequestBody GenreDTO dto) {
        return genreService.create(dto);
    }

    @PutMapping("/{id}")
    public GenreDTO update(@PathVariable Long id, @RequestBody GenreDTO dto) {
        return genreService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        genreService.delete(id);
    }
}
