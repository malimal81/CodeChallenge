package com.csv.parser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.lang.*;
import java.text.DecimalFormat;

public class Calculator {
	private List<Employee> employees = new ArrayList<>();
	
	public Calculator(List<Employee> employees) {
		this.employees = employees;
	}

	public void totalSalary () {
		double sum = 0.0;
		for (Employee employee:employees) {
			sum += employee.getAnnualSalary();
		}
		String pattern = "###,###,###,###.##";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		String number = decimalFormat.format(sum);
		System.out.println("Total Salary: $" + number);
	}
	
	public void totalSalaryByRole () {
		Set<String> roles = new HashSet<>();
		for (Employee employee:employees) {
			roles.add(employee.getRole());
		}
		for (String role:roles) {
			double sum = 0.0;
			for (Employee employee:employees) {
				if (role.equals(employee.getRole())) {
					sum += employee.getAnnualSalary();
				}
			}
			String pattern = "###,###,###,###.##";
			DecimalFormat decimalFormat = new DecimalFormat(pattern);
			String number = decimalFormat.format(sum);
			System.out.println("Total Salary for " + role + "(s): $" + number);
		}
	}
	
	
	public void totalSalaryByTime () {
		double sum = 0.0;
		for (Employee employee:employees) {
			sum += employee.getAnnualSalary();
		}
		String time = "";
		for (int i = 0;i <= 5; i++) {
			double salary = sum;
			switch (i) {
			case 0:
				time = "hour";
				salary = salary/(52*5*8);
				break;
			case 1:
				time = "day";
				salary = salary/(52*5);
				break;
			case 2:
				time = "week";
				salary = salary/(52);
				break;
			case 3:
				time = "month";
				salary = salary/(12);
				break;
			case 4:
				time = "quarter";
				salary = salary/(4);
				break;
			default:
				time = "year";
			}
			String pattern = "###,###,###,###.##";
			DecimalFormat decimalFormat = new DecimalFormat(pattern);
			String number = decimalFormat.format(salary);
			System.out.println("Total Salary per " + time + ": $" + number);
		}
			
	}
	
	public void totalSalaryByRoleAndTime () {
		Set<String> roles = new HashSet<>();
		for (Employee employee:employees) {
			roles.add(employee.getRole());
		}
		for (String role:roles) {
			double sum = 0.0;
			for (Employee employee:employees) {
				if (role.equals(employee.getRole())) {
					sum += employee.getAnnualSalary();
				}
			}
			String time = "";
			for (int i = 0;i <= 5; i++) {
				double salary = sum;
				switch (i) {
				case 0:
					time = "hour";
					salary = salary/(52*5*8);
					break;
				case 1:
					time = "day";
					salary = salary/(52*5);
					break;
				case 2:
					time = "week";
					salary = salary/(52);
					break;
				case 3:
					time = "month";
					salary = salary/(12);
					break;
				case 4:
					time = "quarter";
					salary = salary/(4);
					break;
				default:
					time = "year";
				}
				String pattern = "###,###,###,###.##";
				DecimalFormat decimalFormat = new DecimalFormat(pattern);
				String number = decimalFormat.format(salary);
				System.out.println("Total Salary per " + time + " for " + role + "(s): $" + number);
			}
		}
	}
	
	public void maxGroup (Double maxSalary) {
		String pattern = "###,###,###,###.##";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		List<Employee> maxSalaryList = new ArrayList<>();
		List<Employee> tempEmployees = new ArrayList<>(employees);
		List<Double> salaries = new ArrayList<>();
		double total = 0.0;
		
		for (Employee employee:employees) {
			salaries.add(employee.getAnnualSalary());
		}
		
		SortedSet<Double> sortedSalaries = new TreeSet<>(salaries);
		
		OUTER: for (Double salary:sortedSalaries) {
			for (Employee employee:employees) {
				if (employee.getAnnualSalary().equals(salary)) {
					if ((total + employee.getAnnualSalary()) < maxSalary) {
						maxSalaryList.add(employee);
						total += employee.getAnnualSalary();
						tempEmployees.remove(employee);
					} else {
						break OUTER;
					}
				}
			}
		}
		total = 0;
		for (Employee employee:maxSalaryList) {
			total += employee.getAnnualSalary();
			String number = decimalFormat.format(employee.getAnnualSalary());
			System.out.println("Name: " + employee.getName() + ", Salary: $" + number);
		}
		
		String number = decimalFormat.format(total);
		System.out.println("Total Salary: $" +  number);
	}

}
