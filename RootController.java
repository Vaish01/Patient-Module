package com.pregister.email;

import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pregister.model.Patient;
import com.pregister.repository.RegistrationRepository;
import com.pregister.service.RegistrationService;



@RestController
public class RootController {

	SmtpMailSender smtp = new SmtpMailSender();
	
	@Autowired
	private SmtpMailSender smtpMailSender;
	@Autowired
	private RegistrationService service;

	//@PostMapping("/sendmail")
	//@RequestMapping(name = "/sendmail", method = RequestMethod.GET)
	@GetMapping("/sendmail")
	public int sendMail() throws MessagingException {
		
		
		
		
		smtpMailSender.send("yogitaonlit@gmail.com", "Smart Cognitive Medicaid System ", "Your OTP is:");
		return smtpMailSender.getOtp();
		
	}
	

	
	/*@PutMapping("/updatepatient/{emailId}")
	public boolean fetchPatientById(@PathVariable String emailId) {
		 Patient patient = new Patient();
		patient= service.fetchPatientByEmailId(emailId);
		
		if(patient.getEmailId() != null)
		{
			patient.setPassword("Test");
		}
		Patient updatedPatient = patient;
		
		service.savePatient(updatedPatient);
		
          return true;
	}*/
	//@RequestMapping(value = "/login", method = RequestMethod.POST)
	//public @ResponseBody String postLogin(String user) {
		//String userName = null;
		//if(user !=null) {
		  // userName = user.trim();
		//}
		//return userName;

}
