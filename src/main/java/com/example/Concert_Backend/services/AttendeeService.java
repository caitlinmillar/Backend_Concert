package com.example.Concert_Backend.services;

import com.example.Concert_Backend.models.Attendee;
import com.example.Concert_Backend.repositories.AttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendeeService {
    @Autowired
    AttendeeRepository attendeeRepository;

    public List<Attendee>getAllAttendees(){
        return attendeeRepository.findAll();
    }
    public Attendee getAttendeeById(Long id){
        return attendeeRepository.findById(id).get();
    }
    public Attendee addNewAttendee(Attendee attendee){
        attendeeRepository.save(attendee);
        return attendee;
    }

}
