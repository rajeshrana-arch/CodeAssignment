package com.hsbc.assignment;

import com.hsbc.assignment.Employee;
import com.hsbc.assignment.FindAverageSalaryApp;

import java.util.*;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest     
{
	@Test
    void testCalculateAverageSalary() {
        // Sample employee data
        List<Employee> employees = Arrays.asList(
            new Employee("Ashish", "A", "IT", "Pune", "Software Engineer", new Double(10000)),
            new Employee("Amit", "R", "HR", "Pune", "Recruiter", new Double(12000)),
            new Employee("Ramesh", "D", "HR", "Pune", "Senior Recruiter", new Double(14000)),
            new Employee("Jaya", "S", "IT", "Pune", "Tech Lead", new Double(15000)),
            new Employee("Smita", "M", "IT", "Bangalore", "Recruiter", new Double(16000)));
        // Expected result
        Map<String, Double> expected = new HashMap <String, Double>(){{
           put("Pune_Tech Lead", new Double(15000.0));
           put("Pune_Senior Recruiter", new Double(14000.0));
           put("Bangalore_Recruiter", new Double(16000.0));
           put("Pune_Software Engineer", new Double(10000.0));
           put("Pune_Recruiter", new Double(19000.00));
        }};
        // Calculate average salary
        Map<String, Double> averageSalaryMap = FindAverageSalaryApp.findAverageSalary(employees);
      // Check if the result matches the expected values
        assertEquals(expected.size(), averageSalaryMap.size());
        expected.forEach((key, expectedValue) -> {
            assertEquals(expectedValue, averageSalaryMap.get(key));
        });
    }
}
