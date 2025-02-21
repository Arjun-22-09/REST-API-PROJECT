package com.arjun.springapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arjun.springapp.Entity.Venue;

public interface VenueRepository extends JpaRepository<Venue,Integer>{

}
