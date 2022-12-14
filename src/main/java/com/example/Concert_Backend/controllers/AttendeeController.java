package com.example.Concert_Backend.controllers;

import com.example.Concert_Backend.models.Attendee;
import com.example.Concert_Backend.repositories.AttendeeRepository;
import com.example.Concert_Backend.services.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/attendees")
public class AttendeeController {


    @Autowired
    AttendeeService attendeeService;

    @Autowired
    AttendeeRepository attendeeRepository;

    // getting all attendees
    @GetMapping
    public ResponseEntity<List<Attendee>> getAllAttendees(){
        List<Attendee> attendees = attendeeService.getAllAttendees();
        return new ResponseEntity<>(attendees, HttpStatus.OK);
    }

    // getting attendee by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Attendee> getAttendeeById(@PathVariable long id){
        Optional<Attendee> attendee = attendeeService.getAttendeeById(id);
        if (attendee.isPresent()){
            return new ResponseEntity(attendee.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity("Attendee with this id does not exist", HttpStatus.NOT_FOUND);
        }
    }

    // adding new attendee
    @PostMapping
    public ResponseEntity<Attendee> addNewAttendee(@RequestBody Attendee attendee){
        Attendee savedAttendee = attendeeService.addNewAttendee(attendee);
        return new ResponseEntity<>(savedAttendee, HttpStatus.CREATED);
    }

    // updating attendee
    @PutMapping(value = "/{id}")
    public ResponseEntity<Attendee> updateAttendee(@RequestBody Attendee attendee, @PathVariable Long id){
        Attendee updatedAttendee = attendeeService.updateAttendee(id, attendee);
        return new ResponseEntity<>(updatedAttendee, HttpStatus.OK);
    }

    // deleting attendee by id
    @DeleteMapping(value = "/{id}")
    public ResponseEntity removeAttendee(@PathVariable Long id){
        attendeeService.deleteAttendee(id);
        return new ResponseEntity("Successfully deleted attendee", HttpStatus.OK);
    }

    // getting just the names of the attendees
    @GetMapping(value = "/names")
    public ResponseEntity<List<String>> getNamesOfAttendees (){
        return new ResponseEntity<>(attendeeRepository.findByAttendeesAndFilterByName(), HttpStatus.OK);
    }

    @GetMapping(value = "/numberOfAttendees")
    public ResponseEntity<Integer> getNumberOfAttendees (){
        return new ResponseEntity<>(attendeeRepository.findNumberOfAttendees(), HttpStatus.OK);
    }
}
