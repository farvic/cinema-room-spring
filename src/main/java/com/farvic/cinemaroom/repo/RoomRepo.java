package com.farvic.cinemaroom.repo;

import com.farvic.cinemaroom.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepo extends JpaRepository<Room, Long> {}
