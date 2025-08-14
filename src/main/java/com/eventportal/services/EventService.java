package com.eventportal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.eventportal.model.Event;
import com.eventportal.repository.EventRepository;

@Service
public class EventService {

	
	private final EventRepository eventRepository;
	
	public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
	
	public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
	
	public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }
}
