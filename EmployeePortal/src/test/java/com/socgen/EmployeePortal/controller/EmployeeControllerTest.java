package com.socgen.EmployeePortal.controller;

import com.socgen.EmployeePortal.model.Employee;
import com.socgen.EmployeePortal.service.EmployeeService;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    public EmployeeController employeeController;

    @Before
    public void setup() {
        List<Employee> employees = getEmployees();
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employees);
        Mockito.when(employeeService.getEmployeeById(2)).thenReturn(employees.get(0));
    }

    @Test
    public void test_getAllEmployees() {
        List<Employee> list = employeeController.getAllEmployees();
        assertTrue(!list.isEmpty());
    }

    @Test
    public void test_getEmployee() {
        Employee emp = employeeController.getEmployee(2);
        assertNotNull(emp);
        assertEquals(emp.getFirstname(), "manju");
    }


    @Test
    public void test_saveandDeleteEmployee() {
        employeeController.deleteEmployee(2);
        int empId = employeeController.saveEmployee(getEmployees().get(0));
        assertEquals(empId, 2);
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
