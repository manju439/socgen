package com.socgen.EmployeePortal.service;


import com.socgen.EmployeePortal.dao.EmployeeRepository;
import com.socgen.EmployeePortal.model.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;


    @Before
    public void setup() {
        List<Employee> employees = getEmployees();
        Mockito.when(employeeRepository.findAll()).thenReturn(employees);
        Mockito.when(employeeRepository.findById(5)).thenReturn(Optional.of(employees.get(0)));
        Mockito.when(employeeRepository.findById(1)).thenReturn(Optional.empty());
    }

    @Test
    public void test_getAllEmployees() {
        List<Employee> list = employeeService.getAllEmployees();
        assertTrue(!list.isEmpty());
        assertTrue(list.get(0).getFirstname().equals("akash"));
    }

    @Test
    public void test_getEmployeeById() {
        Employee emp = employeeService.getEmployeeById(5);
        assertTrue(emp.getFirstname().equals("manju"));
        emp = employeeService.getEmployeeById(1);
        assertNull(emp);
    }


    private List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        Employee emp = new Employee();
        emp.setId(2);
        emp.setFirstname("manju");
        emp.setLastname("S");
        emp.setDob("19-12-1990");
        emp.setDepartment("APPS");
        employees.add(emp);
        Employee emp1 = new Employee();
        emp1.setId(5);
        emp1.setFirstname("akash");
        emp1.setLastname("k");
        emp1.setDob("02-12-2010");
        emp1.setDepartment("HR");
        employees.add(emp1);

        return employees;
    }

}
