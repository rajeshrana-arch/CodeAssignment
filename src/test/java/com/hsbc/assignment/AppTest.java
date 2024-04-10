package com.hsbc.assignment;

import com.hsbc.assignment.Employee;
import com.hsbc.assignment.FindAverageSalaryApp;

import java.util.*;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
           put("Pune,Tech Lead", new Double(15000.0));
           put("Pune,Senior Recruiter", new Double(14000.0));
           put("Bangalore,Recruiter", new Double(16000.0));
           put("Pune,Software Engineer", new Double(10000.0));
           put("Pune,Recruiter", new Double(12000.0));
        }};
        // Calculate average salary
        Map<String, Double> averageSalaryMap = FindAverageSalaryApp.findAverageSalary(employees);
      // Check if the result matches the expected values
        assertEquals(expected.size(), averageSalaryMap.size());
        expected.forEach((key, expectedValue) -> {
            assertEquals(expectedValue, averageSalaryMap.get(key));
        });
    }
    @Test
    void testFindAverageSalaryWithBlankSalary() {
        List<Employee> employees = Arrays.asList();
        // Calculate average salary
        Map<String, Double> averageSalaryMap = FindAverageSalaryApp.findAverageSalary(employees);
        // Check if the result matches the expected values
        assertTrue(averageSalaryMap.isEmpty());
    }
    @Test
    void testFindAverageSalaryWithSingleEmployee() {
        List<Employee> employees = Arrays.asList(
                new Employee("Ashish", "A", "IT", "Pune", "Software Engineer", new Double(10000))
        );
        // Calculate average salary
        Map<String, Double> averageSalaryMap = FindAverageSalaryApp.findAverageSalary(employees);
        // Expected result
        Map<String, Double> expected = new HashMap <String, Double>(){{
            put("Pune,Software Engineer", new Double(10000.0));
        }};
        assertEquals(expected.size(), averageSalaryMap.size());
        expected.forEach((key, expectedValue) -> {
            assertEquals(expectedValue, averageSalaryMap.get(key));
        });
    }
    @Test
    void testFindAverageSalaryWithSameGroup() {
        List<Employee> employees = Arrays.asList(
                new Employee("Ashish", "A", "IT", "Pune", "Recruiter", new Double(10000)),
                new Employee("Amit", "R", "HR", "Pune", "Recruiter", new Double(12000)),
                new Employee("Ramesh", "D", "HR", "Pune", "Recruiter", new Double(14000))
        );
        // Calculate average salary
        Map<String, Double> averageSalaryMap = FindAverageSalaryApp.findAverageSalary(employees);
        // Expected result
        Map<String, Double> expected = new HashMap <String, Double>(){{
            put("Pune,Recruiter", new Double(12000.0));
        }};
        assertEquals(expected.size(), averageSalaryMap.size());
        expected.forEach((key, expectedValue) -> {
            assertEquals(expectedValue, averageSalaryMap.get(key));
        });
    }
    @Test
    void testFindAverageSalaryWithEqualSalariesSameGroup() {
        List<Employee> employees = Arrays.asList(
                new Employee("Ashish", "A", "IT", "Pune", "Recruiter", new Double(10000)),
                new Employee("Amit", "R", "HR", "Pune", "Recruiter", new Double(10000)),
                new Employee("Ramesh", "D", "HR", "Pune", "Recruiter", new Double(10000))
        );
        // Calculate average salary
        Map<String, Double> averageSalaryMap = FindAverageSalaryApp.findAverageSalary(employees);
        // Expected result
        Map<String, Double> expected = new HashMap <String, Double>(){{
            put("Pune,Recruiter", new Double(10000.0));
        }};
        assertEquals(expected.size(), averageSalaryMap.size());
        expected.forEach((key, expectedValue) -> {
            assertEquals(expectedValue, averageSalaryMap.get(key));
        });

    }
}
