package com.example.EMS.Services;

import com.example.EMS.Model.Employee;
import com.example.EMS.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServicesImpl implements EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if(optional.isPresent()){
            employee = optional.get();
        }else{
            throw new RuntimeException("Employee Not Found for id :"+ id);
        }
        return employee;
    }

    @Override
    public void deleteEmployeeByID(long id) {
        this.employeeRepository.deleteById(id);
    }
}
