package com.example.Concert_Backend.repositories;

import com.example.Concert_Backend.models.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConcertRepository extends JpaRepository<Concert, Long> {

    // SQL query that orders the concerts by capacity from lowest to highest
    @Query (value = "SELECT*FROM concerts ORDER BY capacity", nativeQuery = true)
    List<Concert> findByConcertAndSortByCapacity();


}
