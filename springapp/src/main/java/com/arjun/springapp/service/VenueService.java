package com.arjun.springapp.service;
import com.arjun.springapp.Entity.Venue;
import com.arjun.springapp.Repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class VenueService {

    @Autowired
    private VenueRepository venueRepository;

    // Get all venues
    public List<Venue> getAllVenues() {
        return venueRepository.findAll();
    }

    // Get venue by ID
    public Optional<Venue> getVenueById(int id) {
        return venueRepository.findById(id);
    }

    // Create a new venue
    public Venue addVenue(Venue venue) 
    {
        return venueRepository.save(venue);
    }

    // Update an existing venue
    public Venue updateVenue(int id, Venue venueDetails) 
    {
        return venueRepository.findById(id)
        .map(venue -> 
        {
            if(venueDetails.getName()!= null)venue.setName(venueDetails.getName());
            if(venueDetails.getCapacity()!= null)venue.setCapacity(venueDetails.getCapacity());
            return venueRepository.save(venue);
        }).orElseThrow(()->new RuntimeException("Id not found"));
    }

    // Delete a venue
    public void deleteVenue(int id) {
        venueRepository.deleteById(id);
    }
}
