package com.arjun.springapp.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "venue")
public class Venue {

    @Id
    public int id;
    public String name;
    public Long capacity;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getCapacity() {
        return capacity;
    }
    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }
    public Venue(int id, String name, Long capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }
    public Venue() {
    }
    

}
