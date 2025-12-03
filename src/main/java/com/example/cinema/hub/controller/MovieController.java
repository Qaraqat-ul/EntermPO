package com.example.cinema.hub.controller;

import com.example.cinema.hub.dto.MovieDTO;
import com.example.cinema.hub.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public List<MovieDTO> getAll() {
        return movieService.getAll();
    }

    @GetMapping("/{id}")
    public MovieDTO getById(@PathVariable Long id) {
        return movieService.getById(id);
    }

    @PostMapping
    public MovieDTO create(@RequestBody MovieDTO dto) {
        return movieService.create(dto);
    }

    @PutMapping("/{id}")
    public MovieDTO update(@PathVariable Long id, @RequestBody MovieDTO dto) {
        return movieService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieService.delete(id);
    }
}

