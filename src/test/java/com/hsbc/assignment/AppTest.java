package com.hsbc.assignment;

import com.hsbc.assignment.Employee;
import java.util.List;
import java.util.Map;
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
        List<Employee> employees = List.of(
                new Employee("Ashish", "A", "IT", "Pune", "Software Engineer", new Double(10000)),
                new Employee("Amit", "R", "HR", "Pune", "Recruiter", new Double(12000)),
                new Employee("Ramesh", "D", "HR", "Pune", "Senior Recruiter", new Double(14000))
            //    new Employee("San Francisco", "Manager", 110000),
             //   new Employee("San Francisco", "Developer", 90000)
        );

        // Expected result
        Map<String, Double> expected = Map.of(
                "New York_Manager", 110000.0,
                "New York_Developer", 80000.0,
                "San Francisco_Manager", 110000.0,
                "San Francisco_Developer", 90000.0
        );

        // Calculate average salary
        Map<String, Double> averageSalaryMap = AverageSalaryCalculator.calculateAverageSalary(employees);

        // Check if the result matches the expected values
        assertEquals(expected.size(), averageSalaryMap.size());
        expected.forEach((key, expectedValue) -> {
            assertEquals(expectedValue, averageSalaryMap.get(key));
        });
    }
}
