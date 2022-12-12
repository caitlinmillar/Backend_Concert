package com.example.Concert_Backend.controllers;

import com.example.Concert_Backend.models.Attendee;
import com.example.Concert_Backend.repositories.AttendeeRepository;
import com.example.Concert_Backend.services.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendees")
public class AttendeeController {
    @Autowired
    AttendeeService attendeeService;
    @Autowired
    private AttendeeRepository attendeeRepository;

    @GetMapping
    public ResponseEntity<List<Attendee>> getAllAttendees(){
        List<Attendee> attendees = attendeeService.getAllAttendees();
        return new ResponseEntity<>(attendees, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Attendee> getAttendeeById(@PathVariable long id){
        Attendee attendee = attendeeService.getAttendeeById(id);
        return new ResponseEntity<>(attendee, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Attendee> addNewAttendee(@RequestBody Attendee attendee){
        Attendee savedAttendee = attendeeService.addNewAttendee(attendee);
        return new ResponseEntity<>(savedAttendee, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> removeAttendee(@PathVariable Long id){
        attendeeRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Attendee> updateAttendee(@RequestParam Attendee attendee, @PathVariable Long id){
        Attendee attendeeUpdate = attendeeRepository.findById(id).get();
        attendeeUpdate.setName(attendee.getName());
        attendeeUpdate.setEmailAddress(attendee.getEmailAddress());
        attendeeUpdate.setPhoneNumber(attendee.getPhoneNumber());
        attendeeRepository.save(attendeeUpdate);
        return new ResponseEntity<>(attendeeUpdate, HttpStatus.OK);
    }

}
