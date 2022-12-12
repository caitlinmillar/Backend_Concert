package com.example.Concert_Backend.controllers;

import com.example.Concert_Backend.models.Concert;
import com.example.Concert_Backend.repositories.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/concerts")
public class ConcertController {
    @Autowired
    ConcertRepository concertRepository;

    //Getting all concerts
    @GetMapping
    public ResponseEntity<List<Concert>> getAllConcerts (){
        return new ResponseEntity<>(concertRepository.findAll(), HttpStatus.OK);
    }

    //Getting a concert by ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Concert>> getConcertById (@PathVariable Long id){
        return new ResponseEntity<>(concertRepository.findById(id), HttpStatus.OK);
    }

    //Posting/adding concert
    @PostMapping
    public ResponseEntity<Concert> postConcert (@RequestBody Concert concert){
        concertRepository.save(concert);
        return new ResponseEntity<>(concert, HttpStatus.CREATED);
    }

    //Removing concert
    @DeleteMapping (value = "/{id}")
    public ResponseEntity<Long> removeConcert (@PathVariable Long id){
        concertRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    //Update concert details
    @PutMapping (value = "/{id}")
    public ResponseEntity<Concert> updateConcert (@RequestParam Concert concert, @PathVariable Long id){
        Concert concertUpdate = concertRepository.findById(id).get();
//        concertUpdate.setArtist(concert.getArtist);
        concertUpdate.setAttendees(concert.getAttendees());
        concertUpdate.setDate(concert.getDate());
        concertUpdate.setTime(concert.getTime());
        concertUpdate.setCapacity(concert.getCapacity());
        concertRepository.save(concertUpdate);
        return new ResponseEntity<>(concertUpdate, HttpStatus.OK);
    }

    //Add attendee to concert

    //Remove attendee from concert


}
