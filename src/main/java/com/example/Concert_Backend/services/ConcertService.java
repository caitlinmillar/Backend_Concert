package com.example.Concert_Backend.services;

import com.example.Concert_Backend.models.Attendee;
import com.example.Concert_Backend.models.Concert;
import com.example.Concert_Backend.repositories.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ConcertService {
    @Autowired
    ConcertRepository concertRepository;
    @Autowired
    AttendeeService attendeeService;


    // Adding new concert
    public Concert addNewConcert(Concert concert){
        concertRepository.save(concert);
        return concert;
    }
    //Deleting concert
    public void deleteConcert(Long id){
    concertRepository.deleteById(id);
    }
    //Get all concerts
    public List<Concert>getAllConcerts (){
        return concertRepository.findAll();
    }
    //Getting concert by Id
    public Concert getConcertById (Long id){
        return concertRepository.findById(id).get();
    }
    //Adding attendee to concert
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
