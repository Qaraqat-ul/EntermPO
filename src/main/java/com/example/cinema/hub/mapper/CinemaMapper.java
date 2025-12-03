package com.example.cinema.hub.mapper;

import com.example.cinema.hub.dto.CinemaDTO;
import com.example.cinema.hub.entity.Cinema;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CinemaMapper {

    CinemaDTO toDto(Cinema cinema);
    Cinema toEntity(CinemaDTO dto);
    List<CinemaDTO> toDtoList(List<Cinema> cinemas);
}
