package com.example.queryingRepo.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EmployeeDto {
    @NotBlank
    private String employeeId;

}
