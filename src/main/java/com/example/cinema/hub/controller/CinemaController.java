package com.example.cinema.hub.controller;

import com.example.cinema.hub.dto.CinemaDTO;
import com.example.cinema.hub.service.CinemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cinemas")
public class CinemaController {

    private final CinemaService cinemaService;

    @GetMapping
    public List<CinemaDTO> getAll() {
        return cinemaService.getAll();
    }

    @GetMapping("/{id}")
    public CinemaDTO getById(@PathVariable Long id) {
        return cinemaService.getById(id);
    }

    @PostMapping
    public CinemaDTO create(@RequestBody CinemaDTO dto) {
        return cinemaService.create(dto);
    }

    @PutMapping("/{id}")
    public CinemaDTO update(@PathVariable Long id, @RequestBody CinemaDTO dto) {
        return cinemaService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        cinemaService.delete(id);
    }
}
