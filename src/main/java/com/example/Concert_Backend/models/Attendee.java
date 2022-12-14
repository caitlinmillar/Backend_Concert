package com.example.Concert_Backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity (name = "attendees")
public class Attendee {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "attendee_id")
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "emailAddress")
    private String emailAddress;

    @Column (name = "phoneNumber")
    private long phoneNumber;

    @JsonIgnoreProperties({"attendees"})
    @ManyToMany(mappedBy = "attendees")
    private List<Concert> concerts;


    public Attendee(String name, String emailAddress, long phoneNumber){
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.concerts = new ArrayList<>();
    }

    public Attendee(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Concert> getConcerts() {
        return concerts;
    }

    public void setConcerts(List<Concert> concerts) {
        this.concerts = concerts;
    }

}
