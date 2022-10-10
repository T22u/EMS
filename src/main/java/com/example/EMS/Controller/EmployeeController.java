package com.example.EMS.Controller;

import com.example.EMS.Model.Employee;
import com.example.EMS.Services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping("/")
    public String ViewHomePage(Model model){
        model.addAttribute("listEmployees",employeeServices.getAllEmployees());
        return "index";
    }
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeServices.saveEmployee(employee);//save employee to database
        return "redirect:/";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
        //get the employee from the service
        Employee employee = employeeServices.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "update_employee";
    }
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id){
        this.employeeServices.deleteEmployeeByID(id);
        return "redirect:/";
    }
}
