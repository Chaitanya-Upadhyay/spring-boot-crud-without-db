package com.spring.employee.springRestEmployee.controller;

import com.spring.employee.springRestEmployee.employeeDto.EmployeeDto;
import com.spring.employee.springRestEmployee.entity.Employee;
import com.spring.employee.springRestEmployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Chaitanya Kumar
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/welcome")
    public String welcome()
    {
        return "This is employee controller testing";
    }

    @GetMapping("/list")
    public List<Employee> list()
    {
        return this.employeeService.getList();
    }

//    Calling DTO to get all details except salary
    @GetMapping("/getDetails")
    public ArrayList<EmployeeDto> getDetails()
    {
        return this.employeeService.listDto();
    }

    @GetMapping("/list/{id}")
    public Employee getEmployee(@PathVariable("id") int id)
    {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/list")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        Employee e=this.employeeService.addEmployee(employee);
        System.out.println(employee);
        return e;
    }

    @DeleteMapping("/list/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId")int employeeId)
    {
        this.employeeService.deleteEmployee(employeeId);
    }

    @PutMapping("/list/{empId}")
    public Employee updateEmployee(@RequestBody Employee employee,@PathVariable("empId") int empId)
    {
        this.employeeService.updateEmployee(employee,empId);
        return employee;
    }
}
