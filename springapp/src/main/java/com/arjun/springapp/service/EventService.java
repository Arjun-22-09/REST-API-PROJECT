package com.arjun.springapp.service;

import com.arjun.springapp.Entity.event;
import com.arjun.springapp.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    // Get all events
    public List<event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Get a single event by ID
    public Optional<event> getEventById(int id) {
        return eventRepository.findById(id);
    }

    // Add a new event
    public event addEvent(event event) {
        return eventRepository.save(event);
    }

    // Update an existing event
    public event updateEvent(int id, event updatedEvent) {
        return eventRepository.findById(id).map(event -> {
            if(updatedEvent.getEventName() != null)event.setEventName(updatedEvent.getEventName());
            if(updatedEvent.getLocation() != null)event.setLocation(updatedEvent.getLocation());
            if(updatedEvent.getDate() != null)event.setDate(updatedEvent.getDate());
            if(updatedEvent.getTime() != null)event.setTime(updatedEvent.getTime());
            return eventRepository.save(event);
        }).orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
    }

    // Delete an event
    public void deleteEvent(int id) {
        eventRepository.deleteById(id);
    }
}
