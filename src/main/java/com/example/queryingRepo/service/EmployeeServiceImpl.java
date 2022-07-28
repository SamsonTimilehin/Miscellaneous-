package com.example.queryingRepo.service;

import com.example.queryingRepo.entity.Employee;
import com.example.queryingRepo.repository.EmployeeRepo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
@Log
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<Employee> save(List<Employee> allEmp) {
        log.info("All Employees in the Service class");
        return employeeRepo.saveAll(allEmp);
    }

    @Override
    public Employee findById(Long id) {
        log.info("test querying for finding id");
        return employeeRepo.findIdUsingQuerying(id);
    }

    @Override
    public Employee findByName(String name) {
        return employeeRepo.findNameUsingQuerying(name);
    }

    @Override
    public String findDateValue(Long id) {
        Employee employee = employeeRepo.findById(id).get();
        Date createdDate = employee.getCreatedAt();

        LocalDateTime dbTime = convertToLocalDateTime(createdDate);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime fiveSecondsAgo = now.minusSeconds(5);
        if(dbTime.isAfter(fiveSecondsAgo)){
            return "Creation time is after two days ago";
        }
        return "It is before two days ago";
    }

    @Override
    public String listValue(List<Employee> employees,Integer id) {
        List<Employee> employeeList = employeeRepo.saveAll(employees);

        Date createdDate = employeeList.get(id).getCreatedAt();

        LocalDateTime dbTime = convertToLocalDateTime(createdDate);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime fiveSecondsAgo = now.minusSeconds(5);
        if(dbTime.isAfter(fiveSecondsAgo)){
            return "Creation time is after five seconds ago";
        }
        return "It is before five seconds ago";
    }

    @Override
    public Employee getAmount() {
        return employeeRepo.getAmount();
    }

    public LocalDateTime convertToLocalDateTime(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

    }
    @Transactional
    public void testTransactional(){
        Employee tranEmployee = getAmount();
    }

}
