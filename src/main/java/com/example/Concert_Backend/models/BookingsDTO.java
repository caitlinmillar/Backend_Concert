package com.example.Concert_Backend.models;

public class BookingsDTO {

    private long attendee_id;

    public BookingsDTO (long attendee_id){
        this.attendee_id = attendee_id;
    }

    public BookingsDTO(){}

    public long getAttendee_id() {
        return attendee_id;
    }

    public void setAttendee_id(long attendee_id) {
        this.attendee_id = attendee_id;
    }

    //message potion, String property
}
