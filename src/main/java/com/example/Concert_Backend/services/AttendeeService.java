package com.example.Concert_Backend.services;

import com.example.Concert_Backend.repositories.AttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendeeService {
    @Autowired
    AttendeeRepository attendeeRepository;


}
