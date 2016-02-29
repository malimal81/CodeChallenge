package com.csv.parser;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Employee {
	private String name;
	private LocalDate dateOfBirth;
	private double annualSalary;
	private String role ;

	public Employee(String name, LocalDate dateOfBirth, String annualSalary, String role) {
		DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.annualSalary = Double.parseDouble(annualSalary);
		this.role = role;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Double getAnnualSalary() {
		return annualSalary;
	}
	public void setAnnualSalary(Double annualSalary) {
		this.annualSalary = annualSalary;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
