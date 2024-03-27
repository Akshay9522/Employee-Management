package com.Emp.entity;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Employee_Details")
public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
private int id;
private String fname;
private String lname;
private String age;
private String gender;
private String dob;
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public Employee(int id, String fname, String lname, String age, String gender, String dob) {
	super();
	this.id = id;
	this.fname = fname;
	this.lname = lname;
	this.age = age;
	this.gender = gender;
	this.dob = dob;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
@Override
public String toString() {
	return "Employee [id=" + id + ", fname=" + fname + ", lname=" + lname + ", age=" + age + ", gender=" + gender
			+ ", dob=" + dob + "]";
}

}
