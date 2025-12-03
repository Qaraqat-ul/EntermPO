package com.example.cinema.hub.mapper;

import com.example.cinema.hub.dto.GenreDTO;
import com.example.cinema.hub.entity.Genre;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenreMapper {

    GenreDTO toDto(Genre genre);
    Genre toEntity(GenreDTO dto);
    List<GenreDTO> toDtoList(List<Genre> genres);
}

