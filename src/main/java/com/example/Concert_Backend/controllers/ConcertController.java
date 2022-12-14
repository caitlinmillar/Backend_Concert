package com.example.Concert_Backend.controllers;

import com.example.Concert_Backend.models.Attendee;
import com.example.Concert_Backend.models.BookingsDTO;
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
@RequestMapping("concerts")
public class ConcertController {
    @Autowired
    ConcertService concertService;
    @Autowired
    private ConcertRepository concertRepository;

    //    Getting all concerts
    @GetMapping
    public ResponseEntity<List<Concert>> getAllConcerts (){
        List<Concert>concerts = concertService.getAllConcerts();
        return new ResponseEntity<>(concerts, HttpStatus.OK);
    }

    //Getting a concert by ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<Concert> getConcertById (@PathVariable Long id){
       Optional<Concert> concert = concertService.getConcertById(id);
        if (concert.isPresent()){
            return new ResponseEntity(concert.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity("Concert of this id does not exist!", HttpStatus.NOT_FOUND);
        }
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
        return new ResponseEntity("Successfully removed concert", HttpStatus.OK);
    }

    //Update concert details
    @PutMapping (value = "/{id}")
    public ResponseEntity<Concert> updateConcert (@RequestBody Concert concert, @PathVariable Long id){
        Concert updatedConcert = concertService.updateConcert(concert, id);
        return new ResponseEntity<>(updatedConcert, HttpStatus.OK);
    }

    //Add attendee to concert
    @PatchMapping (value = "/{id}")
    public ResponseEntity<Concert> addAttendeeToConcert(@PathVariable Long id, @RequestBody BookingsDTO bookingsDTO){
        long attendee_id = bookingsDTO.getAttendee_id();
        Concert updatedConcert = concertService.addAttendeeToConcert(id, attendee_id);
        return new ResponseEntity<>(updatedConcert, HttpStatus.OK);
    }


    // another pathway to possibly use: (get/concerts/:id/attendees)
    // removing attendee from concert
    @DeleteMapping (value = "/{concertId}/attendees/{attendeeId}")
    public ResponseEntity removeAttendeeFromConcert(
            @PathVariable Long concertId,
            @PathVariable Long attendeeId){
        concertService.removeAttendeeFromConcert(concertId, attendeeId);
        return new ResponseEntity("Successfully removed attendee number " + attendeeId + " from concert number " + concertId, HttpStatus.OK);
    }

    // gives you a list of all the concerts based on their capacity from lowest to highest
    // done via SQL query in concert repository
    @GetMapping (value = "/capacities")
    public ResponseEntity<List<Concert>> getConcertsBasedOnCapacity(){
        return new ResponseEntity<>(concertRepository.findByConcertAndSortByCapacity(), HttpStatus.OK);
    }

    @GetMapping (value = "/ticketPrices")
    public ResponseEntity<List<Concert>> getConcertsBasedOnTicketPrice(){
        return new ResponseEntity<>(concertRepository.findByConcertAndSortByTicketPriceDesc(), HttpStatus.OK);
    }

    @GetMapping (value = "/ticketPrices/over150")
    public ResponseEntity<List<Concert>> getConcertsWhereTicketPricesOver150(){
        return new ResponseEntity<>(concertRepository.findByConcertWhereTicketPriceIsGreaterThan150(), HttpStatus.OK);
    }

}
