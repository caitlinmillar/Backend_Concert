package com.example.Concert_Backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity (name = "attendees")
public class Attendee {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "emailAddress")
    private String emailAddress;

    @Column (name = "phoneNumber")
    private Long phoneNumber;

    @JsonIgnoreProperties({"attendees"})
    @ManyToMany(mappedBy = "attendees")
    private List<Concert> concerts;




    public Attendee(String name, String emailAddress, Long phoneNumber){
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.concerts = new ArrayList<>();
    }

    public Attendee(){}



}
