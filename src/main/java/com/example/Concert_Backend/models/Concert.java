package com.example.Concert_Backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity (name = "concerts")
public class Concert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "artist")
    private List<Artist> artist;

    @Column(name = "capacity")
    private Long capacity;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @ManyToMany
    @JoinTable(
            name = "attendees_concerts",
            joinColumns = @JoinColumn(name = "concert_id"),
            inverseJoinColumns = @JoinColumn(name = "attendee_id")
    )

    @JsonIgnoreProperties({"concerts"})
    private List<Attendee> attendees;

    public Concert(Long capacity, String date, String time, Artist artist){
        this.capacity = capacity;
        this.date = date;
        this.time = time;
        this.artist = new ArrayList<>();
        this.attendees = new ArrayList<>();
    }

    public Concert(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Artist> getArtist() {
        return artist;
    }

    public void setArtist(List<Artist> artist) {
        this.artist = artist;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<Attendee> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Attendee> attendees) {
        this.attendees = attendees;
    }
}
