package com.example.EMS.Services;

import com.example.EMS.Model.Employee;

import java.util.List;

public interface EmployeeServices {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployeeByID(long id);
}
