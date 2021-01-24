package com.pregister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pregister.email.SmtpMailSender;
import com.pregister.model.Patient;
import com.pregister.service.RegistrationService;

@RestController
public class RegistrationController {
	
	@Autowired
	private SmtpMailSender smtpMailSender;
	
	public int id;
	
	public Patient updatedPatient;
	
	public int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}


	@Autowired
	private RegistrationService service;
	
	
	//patient-registration//
	@PostMapping("/registerpatient")
	public Patient registerPatient(@RequestBody Patient patient) throws Exception {
		String tempEmailId = patient.getEmailId();
		if(tempEmailId !=null && !"".equals(tempEmailId)) {
			Patient patientObj = service.fetchPatientByEmailId(tempEmailId);
			if(patientObj !=null)
			{
				throw new Exception("Patient with this email-id already exists");
				
			}
		}
		Patient patientObj = null;
		patientObj = service.savePatient(patient);
		return patientObj;
	}
	
	@PostMapping("/login")
	public Patient loginPatient(@RequestBody Patient patient) throws Exception {
		String tempEmailId= patient.getEmailId();
		String tempPass = patient.getPassword();
		Patient patientObj =null;
		if(tempEmailId !=null && tempPass !=null) {
			patientObj =service.fetchPatientByEmailIdAndPassword( tempEmailId, tempPass );
		}
		if(patientObj == null) {
			throw new Exception("Bad credentials");		
			}
		return patientObj;
	}
	
	
	//view details//
	@GetMapping("/getproductbyid/{id}")
	public Patient fetchPatientById(@PathVariable int id) {
	return service.fetchPatientById(id).get(); 
	}
	
    
/*	public boolean fetchPatientByEmailId(String emailId) throws Exception {
		if(emailId !=null) {
			Patient patientObj1 = service.fetchPatientByEmailId(emailId);
		
			if(patientObj1 == null)
			{
			throw new Exception("Invalid email address");
			}
			else
			{
			this.setId(patientObj1.getId());
			}
			return true;
		}
		 return false;
	}*/
	
	@GetMapping("/updatepatient/{emailId}")
	public boolean fetchPatientById(@PathVariable String emailId) {
		 Patient patient = new Patient();
		patient= service.fetchPatientByEmailId(emailId);
		
		 updatedPatient = patient;
		
		service.savePatient(updatedPatient);
		
          return true;
	}
	
	
	@PutMapping("/updatepatient/{password}/{otp}")
	public boolean setPatientById(@PathVariable String password, @PathVariable int otp) {
		if (updatedPatient.getId() == 0)
		{
			return false;
		}
		else {
			
			if (otp == smtpMailSender.getOtp()) {
			updatedPatient.setPassword(password);
			service.savePatient(updatedPatient);
			}
			else
			{
				return false;
			}
			
		}
		
		return true;
	}
}
	
	
     //if email != null {
    	 //call DB for feteching row i.e patient obj.
    	 //if (patient obj == null)
    	 //{
    		 //invalid email/patint not prestn.
    		 
    		 //else 
    	// }
     
	
	



