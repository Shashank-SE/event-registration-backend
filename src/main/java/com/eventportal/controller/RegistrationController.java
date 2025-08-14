package com.eventportal.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventportal.model.Event;
import com.eventportal.model.Registration;
import com.eventportal.repository.EventRepository;
import com.eventportal.services.RegistrationService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class RegistrationController {

	private final RegistrationService registrationService;
    private final EventRepository eventRepository;

    public RegistrationController(RegistrationService registrationService, EventRepository eventRepository) {
        this.registrationService = registrationService;
        this.eventRepository = eventRepository;
    }
    
    @PostMapping("/register")
    public Registration register(@RequestBody RegistrationRequest request) {
        Event event = eventRepository.findById(request.getEventId()).orElseThrow();
        Registration registration = new Registration();
        registration.setName(request.getName());
        registration.setEmail(request.getEmail());
        registration.setEvent(event);
        return registrationService.register(registration);
    }
    
    static class RegistrationRequest {
        private Long eventId;
        private String name;
        private String email;

        public Long getEventId() { return eventId; }
        public void setEventId(Long eventId) { this.eventId = eventId; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
    }
}
