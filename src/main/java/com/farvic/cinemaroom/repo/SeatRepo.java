package com.farvic.cinemaroom.repo;

import com.farvic.cinemaroom.domain.Seat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface SeatRepo extends JpaRepository<Seat, Integer>, JpaSpecificationExecutor<Seat> {

    Optional<Seat> findByRowAndColumn(int row, int column);

    List<Seat> findAllByRow(int row);

}
