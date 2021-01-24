package com.pregister.model;

import javax.persistence.*;

@Entity
public class Patient {
	
@Id
private int id;
private String name;
private String surname;
private String pname;
private String emailId;
private int age;
private String password;
private String phone;
private char sex;
private String address;

public Patient() {
}
public Patient(int id, String name, String surname, String pname, String emailId, int age, String password,
		String phone, char sex, String address) {
	super();
	this.id = id;
	this.name = name;
	this.surname = surname;
	this.pname = pname;
	this.emailId = emailId;
	this.age = age;
	this.password = password;
	this.phone = phone;
	this.sex = sex;
	this.address = address;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSurname() {
	return surname;
}
public void setSurname(String surname) {
	this.surname = surname;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public char getSex() {
	return sex;
}
public void setSex(char sex) {
	this.sex = sex;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
}






