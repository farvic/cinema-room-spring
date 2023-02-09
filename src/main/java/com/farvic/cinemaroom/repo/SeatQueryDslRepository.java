package com.farvic.cinemaroom.repo;

import com.farvic.cinemaroom.domain.Seat;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface SeatQueryDslRepository extends CrudRepository<Seat, Long>, QuerydslPredicateExecutor<Seat> {

}
