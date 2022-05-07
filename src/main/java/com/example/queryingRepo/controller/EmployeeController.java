package com.example.queryingRepo.controller;

import com.example.queryingRepo.entity.Employee;
import com.example.queryingRepo.service.EmployeeService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/saveAll")
    public List<Employee> save(@RequestBody List<Employee> allEmp){
        log.info("About to save all Employee");
        return employeeService.save(allEmp);
    }

    @GetMapping("/date/{id}")
    public String findDateValue(@PathVariable Long id){
        return employeeService.findDateValue(id);
    }

    @GetMapping("/dates/{idValue}")
    public String listValue(List<Employee> employees,@PathVariable Integer idValue){
        return employeeService.listValue(employees,idValue);
    }

    @GetMapping("/{id}")
    public Employee findEmployeeById2(@PathVariable Long id){
        log.info("Controller class findById using querying");
        return employeeService.findById(id);
    }
    @GetMapping("employeeName/{name}")
    public Employee findByEmployeeName(@PathVariable String name){
        log.info("findByName in the controller");
        return employeeService.findByName(name);
    }

}
