package com.socgen.EmployeePortal.dao;

import com.socgen.EmployeePortal.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {}