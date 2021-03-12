package com.oving.DeltakerlisteDemo.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Attendee {

    @Id
    private int phoneNr;
    private String name;

    public Attendee(int phoneNr, String name){

        this.phoneNr = phoneNr;
        this.name = name;

    }

    public Attendee(){

    }

    public int getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(int phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
