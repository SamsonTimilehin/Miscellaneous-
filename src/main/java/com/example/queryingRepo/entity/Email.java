package com.example.queryingRepo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Email {

    @Id
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employeeId")
    private Employee employee;

}
