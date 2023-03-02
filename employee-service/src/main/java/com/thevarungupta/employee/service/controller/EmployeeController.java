package com.thevarungupta.employee.service.controller;

import com.thevarungupta.employee.service.entity.Employee;
import com.thevarungupta.employee.service.payload.EmployeeDepartment;
import com.thevarungupta.employee.service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/employees")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id){
        return service.getEmployeeById(id);
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee){
        return service.saveEmployee(employee);
    }

    @GetMapping("/dep/{id}")
    public EmployeeDepartment getEmployeeWithDepartment(@PathVariable("id") Long id){
        return service.getEmployeeWithDepartment(id);
    }

}
