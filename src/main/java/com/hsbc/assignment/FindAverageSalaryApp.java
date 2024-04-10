/*
Find the Average Salary of the Employee
 */

package com.hsbc.assignment;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindAverageSalaryApp {
    public static Map<String, Double> findAverageSalary(List<Employee> employees){
    //Write your logic here
        return employees.stream()
                .collect(Collectors.groupingBy(
                        emp -> emp.getOfficeLocation() + "," + emp.getDesignation(),
                        Collectors.averagingDouble(Employee::getSalary)
                ));
    }
}