package com.arjun.springapp.controller;

import com.arjun.springapp.Entity.event;
import com.arjun.springapp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/event")
public class Eventcontroller {

    @Autowired
    private EventService eventService;

    // Get all events
    @GetMapping
    public List<event> getAllEvents() {
        return eventService.getAllEvents();
    }

    // Get event by ID
    @GetMapping("/{id}")
    public ResponseEntity<event> getEventById(@PathVariable Long id) {
        Optional<event> event = eventService.getEventById(id);
        return event.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add a new event
    @PostMapping
    public ResponseEntity<event> addEvent(@RequestBody event event) {
        event savedEvent = eventService.addEvent(event);
        return ResponseEntity.ok(savedEvent);
    }

    // Update an existing event
    @PutMapping("/{id}")
    public ResponseEntity<event> updateEvent(@PathVariable Long id, @RequestBody event event) {
        try {
            event updatedEvent = eventService.updateEvent(id, event);
            return ResponseEntity.ok(updatedEvent);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an event
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}
