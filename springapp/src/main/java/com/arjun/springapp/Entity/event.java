package com.arjun.springapp.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "event")
public class event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_id")
    private int id;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "location")
    private String location;

    @Column(name = "event_date")
    private String date;

    @Column(name = "event_time")
    private String time;

    @Column(name = "available_seats")
    private int availableSeats;

    // Default Constructor
    public event() {
    }

    // Parameterized Constructor
    public event(int id, String eventName, String location, String date, String time, int availableSeats) {
        this.id = id;
        this.eventName = eventName;
        this.location = location;
        this.date = date;
        this.time = time;
        this.availableSeats = availableSeats;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}
    