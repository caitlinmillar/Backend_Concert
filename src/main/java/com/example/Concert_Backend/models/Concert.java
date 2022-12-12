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
    @Column (name = "concert_id")
    private Long id;

    @Column(name = "artist")
    private ArrayList<Concert> artists;

    @Column(name = "capacity")
    private long capacity;

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

    public Concert(String artists, long capacity, String date, String time){
        this.capacity = capacity;
        this.date = date;
        this.time = time;
        this.attendees = new ArrayList<>();
        this.artists = new ArrayList<>();
    }

    public Concert(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<Concert> getArtist() {
        return artists;
    }

    public void setArtist(ArrayList<Concert> artist) {
        this.artists = artist;
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

    public void addAttendee(Attendee attendee){
        this.attendees.add(attendee);
    }

    public void removeAttendee(Attendee attendee){
        this.attendees.remove(attendee);
    }
}
//public enum Artist {
//    Fleetwood_Mac,
//    Kendrick_Lamar,
//    David_Bowie,
//    The_Ramones,
//    The_Beetles,
//    Patsy_Cline,
//    Tupac,
//    John_Coltrane,
//    Adele,
//    Billie_Holiday,
//    Billy_Joel,
//
//
//}
