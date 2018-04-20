package com.preccydev.directory.model;

import android.content.Context;


public class Directory {

    private String FirstName;
    private String LastName;
    private int Id;
    private int PhoneNumber;
    private int Level;
    private int Hall;

    public Directory(String firstName, String lastName, int Id, int PNumber,
                     int level, int hall) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Id = Id;
        this.PhoneNumber = PNumber;
        this.Level = level;
        this.Hall = hall;

    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public int getPhoneNumber(){
        return PhoneNumber;
    }

    public void setPhoneNumber(int Phone){
        this.PhoneNumber = Phone;
    }

    public int getHall(){
        return Hall;
    }

    public int getLevel() {
        return Level;
    }

    public void setHall(int hall) {
        Hall = hall;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
}
