package com.example.cinema.hub.repository;

import com.example.cinema.hub.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
