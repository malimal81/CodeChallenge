package com.csv.parser;

import java.util.*;
import java.nio.*;
import java.nio.file.*;
import java.time.format.DateTimeFormatter;
import java.time.*;

public class CSVParser {
	
	public static List<Employee> employees = new ArrayList<>();
	public static DateTimeFormatter format = DateTimeFormatter.ofPattern("M/d/yyyy");

	public static void main(String[] args) {
		
		try {
			List<String> lines = Files.readAllLines(Paths.get(args[0]));
			for (String line:lines) {
				String[] result = line.split(",");
				if (!result[0].equals("NAME")) {
					LocalDate dob = LocalDate.parse("9/9/1999", format);
					try {
						dob = LocalDate.parse(result[1], format);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					
					Employee tempEmployee = new Employee(result[0], dob, result[2], result[3]);
					employees.add(tempEmployee);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Calculator calculator = new Calculator(employees);
		
		if (args[1].equals("1")) {
			calculator.totalSalary();
		} else if (args[1].equals("2")) {
			calculator.totalSalaryByRole();
		} else if (args[1].equals("3")) {
			calculator.totalSalaryByTime();
		} else if (args[1].equals("4")) {
			calculator.totalSalaryByRoleAndTime();
		} else if (args[1].equals("5")) {
			try {
				calculator.maxGroup(Double.parseDouble(args[2]));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Please Enter Valid Arguments");
		}

	}

}
