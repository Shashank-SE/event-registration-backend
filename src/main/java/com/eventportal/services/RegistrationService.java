package com.eventportal.services;

import org.springframework.stereotype.Service;

import com.eventportal.model.Registration;
import com.eventportal.repository.RegistrationRepository;

@Service
public class RegistrationService {

	private final RegistrationRepository registrationRepository;
	
	public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }
	
	public Registration register(Registration registration) {
        return registrationRepository.save(registration);
    }
	
}
