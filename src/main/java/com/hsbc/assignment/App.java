/**
 * Main Class
 */

package com.hsbc.assignment;


import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        // Adding Sample Employee
        employees.add(new Employee("Ashish", "A", "IT", "Pune", "Software Engineer", new Double(10000)));
        employees.add(new Employee("Amit", "R", "HR", "Pune", "Recruiter", new Double(12000)));
        employees.add(new Employee("Ramesh", "D", "HR", "Pune", "Senior Recruiter", new Double(14000)));
        employees.add(new Employee("Jaya", "S", "IT", "Pune", "Tech Lead", new Double(15000)));
        employees.add(new Employee("Smita", "M", "IT", "Bangalore", "Recruiter", new Double(16000)));
        employees.add(new Employee("Umesh", "A", "IT", "Bangalore", "Software Engineer", new Double(12000)));
        employees.add(new Employee("Pooja", "R", "HR", "Bangalore", "Software Engineer", new Double(12000)));
        employees.add(new Employee("Ramesh", "D", "HR", "Pune", "Recruiter", new Double(16000)));
        employees.add(new Employee("Bobby", "S", "IT", "Bangalore", "Tech Lead", new Double(20000)));
        employees.add(new Employee("Vipul", "M", "IT", "Bangalore", "Software Engineer", new Double(14000)));
        // Finding the Average Salary.
        Map<String, Double> averageSalaryMap = FindAverageSalaryApp.findAverageSalary(employees);
        // Print results
        averageSalaryMap.forEach((key, value) -> {
            String[] keyParts = key.split(",");
            String officeLocation = keyParts[0];
            String designation = keyParts[1];
            System.out.println(officeLocation + " --> " + designation + " --> " + value);
        });
    }
}


