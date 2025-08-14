package com.eventportal.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.eventportal.model.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

}
