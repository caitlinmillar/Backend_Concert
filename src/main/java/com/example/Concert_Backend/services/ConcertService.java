package com.example.Concert_Backend.services;

import com.example.Concert_Backend.models.Attendee;
import com.example.Concert_Backend.models.Concert;
import com.example.Concert_Backend.repositories.AttendeeRepository;
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

    @Autowired
    AttendeeRepository attendeeRepository;

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

    //removing attendee from concert
//    public void removeAttendeeFromConcert(long concert_id, long attendee_id){
//        Concert concert = concertRepository.findById(concert_id).get();
//        Attendee attendee = attendeeService.getAttendeeById(attendee_id);
//        List<Attendee> attendees = concert.getAttendees();
//        for(Concert concert : )
//    }

    public void removeAttendeeFromConcert (Long id){
        Attendee foundAttendee = attendeeRepository.findById(id).get();
        for (Concert concert : foundAttendee.getConcerts()){
            concert.removeAttendee(foundAttendee);
        }

    }

    //updating concert details
    public Concert updateConcert(Concert concert, long id){
        Concert concertToUpdate = concertRepository.findById(id).get();
        concertToUpdate.setAttendees(concert.getAttendees());
        concertToUpdate.setDate(concert.getDate());
        concertToUpdate.setTime(concert.getTime());
        concertToUpdate.setCapacity(concert.getCapacity());
        concertRepository.save(concertToUpdate);
        return concertToUpdate;

    }


}
