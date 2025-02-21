package com.arjun.springapp.controller;

import com.arjun.springapp.Entity.Organizer;
import com.arjun.springapp.service.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/organizers")
public class OrganizerController {

    @Autowired
    private OrganizerService organizerService;

    // Get all organizers
    @GetMapping
    public List<Organizer> getAllOrganizers() {
        return organizerService.getAllOrganizers();
    }

    // Get an organizer by ID
    @GetMapping("/{id}")
    public Optional<Organizer> getOrganizerById(@PathVariable int id) {
        return organizerService.getOrganizerById(id);
    }

    // Create a new organizer
    @PostMapping
    public Organizer addOrganizer(@RequestBody Organizer organizer) {
        return organizerService.addOrganizer(organizer);
    }

    // Update an organizer
    @PutMapping("/{id}")
    public Organizer updateOrganizer(@PathVariable int id, @RequestBody Organizer organizer) {
        return organizerService.updateOrganizer(id, organizer);
    }

    // Delete an organizer
    @DeleteMapping("/{id}")
    public String deleteOrganizer(@PathVariable int id) {
        organizerService.deleteOrganizer(id);
        return "Organizer with ID " + id + " deleted successfully.";
    }
}
