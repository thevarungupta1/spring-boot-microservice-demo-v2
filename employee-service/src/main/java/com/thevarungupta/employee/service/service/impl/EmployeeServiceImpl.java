package com.thevarungupta.employee.service.service.impl;

import com.thevarungupta.employee.service.entity.Employee;
import com.thevarungupta.employee.service.payload.Department;
import com.thevarungupta.employee.service.payload.EmployeeDepartment;
import com.thevarungupta.employee.service.repository.EmployeeRepository;
import com.thevarungupta.employee.service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public EmployeeDepartment getEmployeeWithDepartment(Long id) {
        // get employee
        Employee employee = employeeRepository.findById(id).get();

        // get department
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/api/v1/departments/"+
                employee.getDepartmentId(), Department.class);

        // merge employee and department
        EmployeeDepartment response = new EmployeeDepartment();
        response.setDepartment(department);
        response.setEmployee(employee);

        // send response
        return response;

    }
}
