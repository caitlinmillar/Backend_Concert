package com.example.Concert_Backend.controllers;

import com.example.Concert_Backend.models.Attendee;
import com.example.Concert_Backend.models.Concert;
import com.example.Concert_Backend.repositories.ConcertRepository;
import com.example.Concert_Backend.services.ConcertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/concerts")
public class ConcertController {
    @Autowired
    ConcertService concertService;

//    Getting all concerts
    @GetMapping
    public ResponseEntity<List<Concert>> getAllConcerts (){
        List<Concert>concerts = concertService.getAllConcerts();
        return new ResponseEntity<>(concerts, HttpStatus.OK);
    }
    //Getting a concert by ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<Concert> getConcertById (@PathVariable Long id){
        Concert concert = concertService.getConcertById(id);
        return new ResponseEntity<>(concert, HttpStatus.OK);
    }

    //Posting/adding concert
    @PostMapping
    public ResponseEntity<Concert> newConcert (@RequestBody Concert concert){
        Concert savedConcert = concertService.addNewConcert(concert);
        return new ResponseEntity<>(savedConcert, HttpStatus.CREATED);
    }

    //Removing concert
    @DeleteMapping (value = "/{id}")
    public ResponseEntity removeConcert (@PathVariable Long id){
        concertService.deleteConcert(id);
        return new ResponseEntity(null, HttpStatus.OK);
    }

    //Update concert details
    @PutMapping (value = "/{id}")
    public ResponseEntity<Concert> updateConcert (@RequestBody Concert concert, @PathVariable Long id){
        Concert updatedConcert = concertService.updateConcert(concert, id);
        return new ResponseEntity<>(updatedConcert, HttpStatus.OK);
    }

    //Add attendee to concert
    @PatchMapping (value = "/{id}")
    public ResponseEntity<Concert> addAttendeeToConcert(@PathVariable Long id, @RequestParam Attendee attendee){
        long attendee_id = attendee.getId();
//        long concert_id = concert.getId();
        Concert updatedConcert = concertService.addAttendeeToConcert(attendee_id, id);
        return new ResponseEntity<>(updatedConcert, HttpStatus.OK);
    }

    //Remove attendee from concert
    @DeleteMapping (value = "/remove")
    public ResponseEntity<Long> removeAttendeeFromConcert(@PathVariable Long id){
        concertService.removeAttendeeFromConcert(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


}
