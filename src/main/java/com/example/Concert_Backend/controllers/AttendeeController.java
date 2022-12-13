package com.example.Concert_Backend.controllers;

import com.example.Concert_Backend.models.Attendee;
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

    // getting all attendees
    @GetMapping
    public ResponseEntity<List<Attendee>> getAllAttendees(){
        List<Attendee> attendees = attendeeService.getAllAttendees();
        return new ResponseEntity<>(attendees, HttpStatus.OK);
    }

    // getting attendee by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Attendee> getAttendeeById(@PathVariable long id){
        Attendee attendee = attendeeService.getAttendeeById(id);
        return new ResponseEntity<>(attendee, HttpStatus.OK);
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
    public ResponseEntity<Long> removeAttendee(@PathVariable Long id){
        attendeeService.deleteAttendee(id);
        return new ResponseEntity(null, HttpStatus.OK);
    }

}
