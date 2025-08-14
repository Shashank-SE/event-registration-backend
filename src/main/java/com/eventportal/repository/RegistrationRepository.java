package com.eventportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventportal.model.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long>{

}
