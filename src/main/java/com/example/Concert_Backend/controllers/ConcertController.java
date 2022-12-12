package com.example.Concert_Backend.controllers;

import com.example.Concert_Backend.models.Concert;
import com.example.Concert_Backend.repositories.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
