package com.farvic.cinemaroom.repo;

import com.farvic.cinemaroom.domain.Seat;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface SeatRepository extends CrudRepository<Seat, Long> {

    List<Seat> findAllByIsAvailable(boolean isAvailable);

    Seat findByRowAndColumn(int row, int column);

    // @Query("SELECT new Seat(seat.row, seat.column) FROM Seat seat WHERE
    // seat.isAvailable = true")
    // List<Seat> findRowAndColumnByIsAvailable(boolean isAvailable);

    // @Modifying
    // @Query("UPDATE Seat s SET s.isAvailable = :isAvailable WHERE s.id = :id")
    // void updateSeatAvailability(@Param("id") int id, @Param("isAvailable")
    // Boolean isAvailable);

}
