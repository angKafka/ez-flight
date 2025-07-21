package org.rdutta.ezflight.infrastructure.repository;

import org.rdutta.ezflight.domain.model.Flights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface FlightsRepository extends JpaRepository<Flights, Integer> {
    @Query("SELECT f FROM Flights f WHERE f.startTime>=:startTime AND f.from = :from AND f.to = :to")
    List<Flights> findAllFlightsFromSourceToDestination(@Param("from") String from, @Param("to") String to, @Param("startTime") LocalTime startTime);
}
