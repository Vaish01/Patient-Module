package com.pregister.repository;

import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.pregister.model.Patient;

public interface RegistrationRepository extends JpaRepository<Patient, Integer>{
 public Patient findByEmailId(String emailId);
 public Patient findByEmailIdAndPassword(String emailId, String password);
 
 
 
 

 //@Modifying
 //@Query("UPDATE Patient SET password=newpassword WHERE id in :id")
 //public int toUpperEmployeeFirstNames(@Param(value = "ids") List<Integer> ids);

 }
