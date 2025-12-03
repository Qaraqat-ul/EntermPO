package com.example.cinema.hub.mapper;

import com.example.cinema.hub.dto.CinemaDTO;
import com.example.cinema.hub.entity.Cinema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CinemaMapperTest {

    @Autowired
    private CinemaMapper cinemaMapper;

    @Test
    void convertEntityToDtoTest() {
        Cinema cinema = new Cinema();
        cinema.setId(1L);
        cinema.setName("Chaplin Mega");
        cinema.setAddress("Mega Center, Almaty");
        cinema.setCity("Almaty");

        CinemaDTO dto = cinemaMapper.toDto(cinema);

        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getName());
        Assertions.assertNotNull(dto.getAddress());
        Assertions.assertNotNull(dto.getCity());

        Assertions.assertEquals(cinema.getId(), dto.getId());
        Assertions.assertEquals(cinema.getName(), dto.getName());
        Assertions.assertEquals(cinema.getAddress(), dto.getAddress());
        Assertions.assertEquals(cinema.getCity(), dto.getCity());
    }

    @Test
    void convertDtoToEntityTest() {
        CinemaDTO dto = new CinemaDTO();
        dto.setId(2L);
        dto.setName("Kinopark 8");
        dto.setAddress("Dostyk Plaza, Almaty");
        dto.setCity("Almaty");

        Cinema cinema = cinemaMapper.toEntity(dto);

        Assertions.assertNotNull(cinema);
        Assertions.assertNotNull(cinema.getId());
        Assertions.assertNotNull(cinema.getName());
        Assertions.assertNotNull(cinema.getAddress());
        Assertions.assertNotNull(cinema.getCity());

        Assertions.assertEquals(dto.getId(), cinema.getId());
        Assertions.assertEquals(dto.getName(), cinema.getName());
        Assertions.assertEquals(dto.getAddress(), cinema.getAddress());
        Assertions.assertEquals(dto.getCity(), cinema.getCity());
    }
}

