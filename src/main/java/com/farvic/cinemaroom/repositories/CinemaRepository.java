package com.farvic.cinemaroom.repositories;

import com.farvic.cinemaroom.domain.Cinema;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
// import org.springframework.stereotype.Repository;

@RepositoryRestResource(exported = false)
@Tag(name = "Cinema", description = "Cinema API")
public interface CinemaRepository extends JpaRepository<Cinema, Integer> {

}
