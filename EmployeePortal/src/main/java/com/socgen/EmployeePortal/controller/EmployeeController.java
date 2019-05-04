package com.socgen.EmployeePortal.controller;


import com.socgen.EmployeePortal.model.Employee;
import com.socgen.EmployeePortal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/v1/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/v1/employees/{id}")
    public Employee getEmployee(@PathVariable("id") int id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/v1/employees/{id}")
    public void deleteEmployee(@PathVariable("id") int id) {
        employeeService.delete(id);
    }

    @PostMapping("/v1/employees")
    public int saveEmployee(@RequestBody Employee employee) {
        employeeService.saveOrUpdate(employee);
        return employee.getId();
    }

}
