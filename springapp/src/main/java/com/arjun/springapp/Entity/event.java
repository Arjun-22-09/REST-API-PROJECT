package com.arjun.springapp.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "event", uniqueConstraints = { @UniqueConstraint(columnNames = "event_name") })
public class event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long id;

    @Column(name = "event_name", nullable = false, unique = true)
    private String eventName;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "event_date", nullable = false)
    private String date;

    @Column(name = "event_time", nullable = false)
    private String time;

    @Column(name = "available_seats", nullable = false)
    private int availableSeats;

    // Default Constructor
    public event() {
    }

    // Parameterized Constructor
    public event(Long id, String eventName, String location, String date, String time, int availableSeats, Organizer organizer) {
        this.id = id;
        this.eventName = eventName;
        this.location = location;
        this.date = date;
        this.time = time;
        this.availableSeats = availableSeats;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

