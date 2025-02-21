package com.arjun.springapp.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "organizer")
public class Organizer 
{

    @Id
    public int id;
    public String name;
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
    public Organizer(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Organizer() {
    }
    
}
