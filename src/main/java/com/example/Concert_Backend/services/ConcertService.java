package com.example.Concert_Backend.services;

import com.example.Concert_Backend.models.Attendee;
import com.example.Concert_Backend.models.Concert;
import com.example.Concert_Backend.repositories.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcertService {
    @Autowired
    ConcertRepository concertRepository;
    @Autowired
    AttendeeService attendeeService;

    public Concert addAttendeeToConcert (long concert_id, long attendee_id){
        Concert concert = concertRepository.findById(concert_id).get();
        Attendee attendee = attendeeService.getAttendeeById (attendee_id);
        List<Attendee> attendees = concert.getAttendees();
        attendees.add(attendee);
        concert.setAttendees(attendees);
        concertRepository.save(concert);
        return concert;
    }



}
