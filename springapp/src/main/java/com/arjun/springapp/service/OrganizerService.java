package com.arjun.springapp.service;

import com.arjun.springapp.Entity.Organizer;
import com.arjun.springapp.Repository.OrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizerService {

    @Autowired
    private OrganizerRepository organizerRepository;

    // Get all organizers
    public List<Organizer> getAllOrganizers() {
        return organizerRepository.findAll();
    }

    // Get organizer by ID
    public Optional<Organizer> getOrganizerById(int id) {
        return organizerRepository.findById(id);
    }

    // Create a new organizer
    public Organizer addOrganizer(Organizer organizer) {
        return organizerRepository.save(organizer);
    }

    // Update an existing organizer
    public Organizer updateOrganizer(int id, Organizer organizerDetails) {
        return organizerRepository.findById(id).map(organizer -> {
            organizer.setName(organizerDetails.getName());
            return organizerRepository.save(organizer);
        }).orElse(null);
    }

    // Delete an organizer
    public void deleteOrganizer(int id) {
        organizerRepository.deleteById(id);
    }
}
