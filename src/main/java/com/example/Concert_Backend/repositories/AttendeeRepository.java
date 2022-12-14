package com.example.Concert_Backend.repositories;

import com.example.Concert_Backend.models.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, Long> {

    // SQL query to get names of attendees

    @Query (value = "SELECT name FROM attendees", nativeQuery = true)
    List <String> findByAttendeesAndFilterByName();

    @Query (value = "SELECT COUNT (DISTINCT name) as names FROM attendees", nativeQuery = true)
    int findNumberOfAttendees();
}
