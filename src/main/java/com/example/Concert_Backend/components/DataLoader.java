package com.example.Concert_Backend.components;

import com.example.Concert_Backend.models.Attendee;
import com.example.Concert_Backend.models.Concert;
import com.example.Concert_Backend.repositories.AttendeeRepository;
import com.example.Concert_Backend.repositories.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    ConcertRepository concertRepository;
    @Autowired
    AttendeeRepository attendeeRepository;

    public DataLoader(){
    }

    @Override
    public void run (ApplicationArguments args) throws Exception{
        //Add attendees
        Attendee losh = new Attendee("Losh", "l@gmail.com",07433322345);
        attendeeRepository.save(losh);
        Attendee berna = new Attendee("Berna", "b@gmail.com",07433322344);
        attendeeRepository.save(berna);
        Attendee caitlin = new Attendee("Caitlin", "c@gmail.com",07433322343);
        attendeeRepository.save(caitlin);
        Attendee abdullah = new Attendee("Abdullah", "a@gmail.com",07433322342);
        attendeeRepository.save(abdullah);

        //Add new Concert
        Concert tupacConcert = new Concert("Tupac", 5000, "01/01/2023","19:00");
        tupacConcert.addAttendee(losh);
        tupacConcert.addAttendee(berna);
        tupacConcert.addAttendee(abdullah);
        concertRepository.save(tupacConcert);

        Concert adeleConcert = new Concert("Adele", 2500, "01/01/2024","19:30");
        adeleConcert.addAttendee(losh);
        adeleConcert.addAttendee(berna);
        concertRepository.save(adeleConcert);

        Concert fleetwoodMac = new Concert("Fleetwood Mac", 3, "20/05/1950","4:00");
        fleetwoodMac.addAttendee(caitlin);
        concertRepository.save(fleetwoodMac);

        Concert billyJoel = new Concert("Billy Joel", 600000, "13/12/2013","13:00");
        billyJoel.addAttendee(caitlin);
        billyJoel.addAttendee(berna);
        concertRepository.save(billyJoel);

        Concert kendrick = new Concert("Kendrick Lamar", 4000, "10/09/22","20:00");
        kendrick.addAttendee(berna);
        kendrick.addAttendee(losh);
        kendrick.addAttendee(abdullah);
        concertRepository.save(kendrick);

        Concert fredo = new Concert("Fredo", 500000, "04/04/20","04:20");
        fredo.addAttendee(abdullah);
        fredo.addAttendee(losh);
        concertRepository.save(fredo);










    }



}
