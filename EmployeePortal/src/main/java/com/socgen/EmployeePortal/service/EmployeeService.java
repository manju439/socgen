package com.socgen.EmployeePortal.service;

import com.socgen.EmployeePortal.dao.EmployeeRepository;
import com.socgen.EmployeePortal.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employee -> employees.add(employee));
        return employees.stream().sorted(Comparator.comparing(Employee::getFirstname)).collect(Collectors.toList());
    }

    public Employee getEmployeeById(int id) {
        Optional<Employee> emp = employeeRepository.findById(id);
        if (emp.isPresent()) return emp.get();
        else return null;
    }

    public void saveOrUpdate(Employee employee) {
        employeeRepository.save(employee);
    }

    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}