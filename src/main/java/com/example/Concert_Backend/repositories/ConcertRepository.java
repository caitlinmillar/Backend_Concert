package com.example.Concert_Backend.repositories;

import com.example.Concert_Backend.models.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConcertRepository extends JpaRepository<Concert, Long> {

    // SQL query that orders the concerts by capacity (LOWEST to HIGHEST)
    @Query (value = "SELECT*FROM concerts ORDER BY capacity", nativeQuery = true)
    List<Concert> findByConcertAndSortByCapacity();

    // SQL query to sort concerts by ticket price (HIGHEST to LOWEST)
    @Query (value = "SELECT*FROM concerts ORDER BY ticket_price DESC", nativeQuery = true)
    List <Concert> findByConcertAndSortByTicketPriceDesc();

    // SQL distinct query to find concerts with ticket prices greater than 150
    @Query (value = "SELECT*FROM concerts WHERE ticket_price > 150.00", nativeQuery = true)
    List<Concert> findByConcertWhereTicketPriceIsGreaterThan150();


}
