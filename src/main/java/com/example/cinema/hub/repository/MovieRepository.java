package com.example.cinema.hub.repository;

import com.example.cinema.hub.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
