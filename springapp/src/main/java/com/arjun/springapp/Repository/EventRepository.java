package com.arjun.springapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.arjun.springapp.Entity.event;

public interface EventRepository extends JpaRepository<event, Integer> {
}
