package com.farvic.cinemaroom.repositories;

import com.farvic.cinemaroom.domain.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {

    @Query("SELECT s FROM Seat s WHERE s.cinema.id = ?1")
    List<Seat> findByCinemaId(int cinemaId);

    List<Seat> findByCinemaIdAndIsAvailable(int cinemaId, boolean isAvailable);

    Optional<Seat> findByRowAndColumn(int row, int column);

}
