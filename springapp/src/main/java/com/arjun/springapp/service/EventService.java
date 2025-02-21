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
    public Optional<event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    // Add a new event
    public event addEvent(event event) {
        return eventRepository.save(event);
    }

    // Update an existing event
    public event updateEvent(Long id, event updatedEvent) {
        return eventRepository.findById(id).map(event -> {
            event.setEventName(updatedEvent.getEventName());
            event.setLocation(updatedEvent.getLocation());
            event.setDate(updatedEvent.getDate());
            event.setTime(updatedEvent.getTime());
            event.setAvailableSeats(updatedEvent.getAvailableSeats());
            return eventRepository.save(event);
        }).orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
    }

    // Delete an event
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
