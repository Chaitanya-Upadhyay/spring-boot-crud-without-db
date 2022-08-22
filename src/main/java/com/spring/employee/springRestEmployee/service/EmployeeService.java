package com.spring.employee.springRestEmployee.service;

import com.spring.employee.springRestEmployee.employeeDto.EmployeeDto;
import com.spring.employee.springRestEmployee.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Chaitanya Kumar
 */
@Component
public class EmployeeService {

    private  static List<Employee> list = new ArrayList<>();

    static {
        list.add(new Employee(12, "Amar","Civil", "12345"));
        list.add(new Employee(14, "Akash","ECE", "1234545"));
        list.add(new Employee(18, "Aman","MD", "1234564"));
        list.add(new Employee(17, "Om","CS", "12345789"));
    }

   ArrayList<EmployeeDto> dto=new ArrayList<>();
    public List<Employee> getList() {
        return list;
    }

    public ArrayList<EmployeeDto> listDto()
    {
        dto.removeAll(dto);
        for(
                Employee e:list) {

            dto.add(employeeToDto(e));
        }
        return this.dto;
    }


    // Employee to DTO converter

    private EmployeeDto employeeToDto(Employee employee)
    {
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setDepartment(employee.getDepartment());
      return employeeDto;
    }








    public Employee getEmployeeById(int id)
    {
        Employee employee=null;
        employee=list.stream().filter(e->e.getId()==id).findFirst().get();
        return employee;
    }

    //adding employee
    public Employee addEmployee(Employee e)
    {

        list.add(e);
        return  e;
    }

    public void deleteEmployee(int eid)
    {
        list=list.stream().filter(employee -> employee.getId()!=eid).collect(Collectors.toList());


    }

    public void updateEmployee(Employee employee,int empId)
    {
        list = list.stream().map(b->
        {
            if(b.getId()==empId)
            {
                b.setName((employee.getName()));
                b.setDepartment((employee.getDepartment()));
                b.setSalary((employee.getSalary()));
            }
            return b;
        }).collect(Collectors.toList());
    }
}
