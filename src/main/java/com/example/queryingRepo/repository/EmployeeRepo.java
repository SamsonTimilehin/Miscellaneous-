package com.example.queryingRepo.repository;

import com.example.queryingRepo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {


    @Query(nativeQuery = true, value = "select * from employee where id = ?1")
     Employee findIdUsingQuerying(Long id);

    @Query(nativeQuery = true, value = "select * from employee where name = ?1")
    Employee findNameUsingQuerying(String name);

}
