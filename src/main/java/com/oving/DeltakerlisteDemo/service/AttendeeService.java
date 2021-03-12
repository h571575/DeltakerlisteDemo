package com.oving.DeltakerlisteDemo.service;

import com.oving.DeltakerlisteDemo.dao.AttendeeRepository;
import com.oving.DeltakerlisteDemo.model.Attendee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttendeeService {

    private final AttendeeRepository attendeeRepository;

    @Autowired
    public AttendeeService(@Qualifier("postgres") AttendeeRepository attendeeRepository){
        this.attendeeRepository = attendeeRepository;
    }

    public void addAttendee(Attendee attendee){

        attendeeRepository.save(attendee);

    }

    public void removeAttendeeByNumber(int phoneNr){

        if (attendeeRepository.findById(phoneNr).get() != null){
            Attendee attendee = attendeeRepository.findById(phoneNr).get();
            attendeeRepository.delete(attendee);
        }
        else {
            System.out.println("The attendee does not exist.");
        }

    }

    public List<Attendee> getAllAttendees(){

        List<Attendee> attendees = new ArrayList<>();
        attendeeRepository.findAll().forEach(attendees::add);

        return attendees;

    }

}
