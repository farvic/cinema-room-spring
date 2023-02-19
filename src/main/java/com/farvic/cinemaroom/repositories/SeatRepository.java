package com.farvic.cinemaroom.repositories;

import com.farvic.cinemaroom.domain.Seat;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Tag(name = "Seat", description = "Seat API")
public interface SeatRepository extends JpaRepository<Seat, Integer> {

    /**
     * Find all seats by cinema id
     * 
     * @param cinemaId
     * @return
     */

    @Query("SELECT s FROM Seat s WHERE s.cinema.id = ?1")
    List<Seat> findByCinemaId(@Param("cinemaId") int cinemaId);

    /**
     * Find all the available seats by cinema id
     * 
     * @param cinemaId
     * @param isAvailable
     * @return
     */
    List<Seat> findByCinemaIdAndIsAvailable(@Param("cinemaId") int cinemaId, @Param("isAvailable") boolean isAvailable);

    /**
     * Find a seat by row and column
     * 
     * @param row
     * @param column
     * @return
     */

    Optional<Seat> findByRowAndColumn(@Param("row") int row, @Param("column") int column);

}
