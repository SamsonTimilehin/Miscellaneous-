package com.example.queryingRepo.service;

import com.example.queryingRepo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> save(List<Employee> allEmp);

    Employee findById(Long id);

    Employee findByName(String name);

    String findDateValue(Long id);

    String listValue(List<Employee> employees,Integer id);
}
