package com.arjun.springapp.controller;


import com.arjun.springapp.Entity.Venue;
import com.arjun.springapp.service.VenueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/venues")
public class VenueController {

    @Autowired
    private VenueService venueService;

    // Get all venues
    @GetMapping
    public List<Venue> getAllVenues() {
        return venueService.getAllVenues();
    }

    // Get a venue by ID
    @GetMapping("/{id}")
    public Optional<Venue> getVenueById(@PathVariable int id) {
        return venueService.getVenueById(id);
    }

    // Create a new venue
    @PostMapping
    public Venue addVenue(@RequestBody Venue venue) {
        return venueService.addVenue(venue);
    }

    // Update a venue
    @PutMapping("/{id}")
    public Venue updateVenue(@PathVariable int id, @RequestBody Venue venue) {
        return venueService.updateVenue(id, venue);
    }

    // Delete a venue
    @DeleteMapping("/{id}")
    public String deleteVenue(@PathVariable int id) {
        venueService.deleteVenue(id);
        return "Venue with ID " + id + " deleted successfully.";
    }
}
