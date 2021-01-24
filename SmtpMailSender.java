package com.pregister.email;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


@Component
public class SmtpMailSender {
		
	@Autowired
	private JavaMailSender javaMailSender;
	
	public int otp;
	
	
	
	public int getOtp() {
		return otp;
	}

	protected void setOtp(int otp) {
		this.otp = otp;
	}

	public void send(String to, String subject, String body) throws MessagingException {
		 MimeMessage message = javaMailSender.createMimeMessage();
		 Random random =new Random();
		 this.setOtp(random.nextInt(1000));
		 MimeMessageHelper helper;
		 
		 helper = new MimeMessageHelper(message, true); // true indicates
		   // multipart message
         helper.setSubject(subject);
         helper.setTo(to);
         helper.setText(body+this.getOtp(), true); // true indicates html
// continue using helper object for more functionalities like adding attachments, etc.  

         javaMailSender.send(message);
	}
	
	
	public int add (int a, int b)
	{
		return a + b;
	}

}
