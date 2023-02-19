package com.farvic.cinemaroom.repositories;

import com.farvic.cinemaroom.domain.Cinema;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
@Tag(name = "Cinema", description = "Cinema API")
public interface CinemaRepository extends JpaRepository<Cinema, Integer> {

}
