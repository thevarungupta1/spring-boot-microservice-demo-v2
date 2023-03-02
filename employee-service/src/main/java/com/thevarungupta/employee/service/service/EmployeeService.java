package com.thevarungupta.employee.service.service;

import com.thevarungupta.employee.service.entity.Employee;
import com.thevarungupta.employee.service.payload.EmployeeDepartment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long employeeId);
    Employee saveEmployee(Employee employee);

    EmployeeDepartment getEmployeeWithDepartment(Long id);
}
