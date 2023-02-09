package com.farvic.cinemaroom.repo;

import com.farvic.cinemaroom.domain.Seat;
import com.farvic.cinemaroom.domain.SeatDto;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SeatRepository extends CrudRepository<Seat, Long> {

    // Optional<Seat> findByRowAndColumn(int row, int column);

    List<Seat> findAllByIsAvailable(boolean isAvailable);

    @Query("SELECT new Seat(seat.row, seat.column) FROM Seat seat WHERE seat.isAvailable = true")
    List<Seat> findRowAndColumnByIsAvailable(boolean isAvailable);

    // @Modifying
    // @Query("UPDATE Seat s SET s.isAvailable = :isAvailable WHERE s.id = :id")
    // void updateSeatAvailability(@Param("id") int id, @Param("isAvailable")
    // Boolean isAvailable);

}
