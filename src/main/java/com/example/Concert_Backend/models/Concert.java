package com.example.Concert_Backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity (name = "concerts")
@Getter
@Setter
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

}
