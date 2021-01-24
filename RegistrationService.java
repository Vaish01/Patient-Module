package com.pregister.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pregister.model.Patient;
import com.pregister.repository.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository repo;
	public Patient savePatient(Patient patient) {
		 return repo.save(patient);
	}
	
	public Patient fetchPatientByEmailId(String emailId) {
		 return repo.findByEmailId(emailId);
	}
	
	public Patient fetchPatientByEmailIdAndPassword(String emailId,String password) {
		 return repo.findByEmailIdAndPassword(emailId, password);
	}
	public Optional<Patient> fetchPatientById(int id) {
		return repo.findById(id);
	}
	
}
