package com.oving.DeltakerlisteDemo.controller;

import com.oving.DeltakerlisteDemo.model.Attendee;
import com.oving.DeltakerlisteDemo.service.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class AttendeeController {

    private final AttendeeService service;

    @Autowired
    public AttendeeController(AttendeeService service){
        this.service = service;
    }

    @RequestMapping("/add")
    public ModelAndView addAttendee(Attendee attendee){
        var modelAndView = new ModelAndView("addAttendee");

        return modelAndView.addObject("attendee", attendee);
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public RedirectView saveAttendee(@ModelAttribute("attendee") Attendee attendee){
        service.addAttendee(attendee);
        return new RedirectView("showAttendees");
    }


    @RequestMapping("/showAttendees")
    public ModelAndView showAttendees(){

        ModelAndView modelAndView = new ModelAndView("showAttendees");
        var attendees = service.getAllAttendees();
        return modelAndView.addObject("attendees",attendees);
    }



}
