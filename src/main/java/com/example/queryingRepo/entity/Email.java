package com.example.queryingRepo.entity;

import javax.persistence.*;

@Entity
public class Email {

    @Id
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employeeId")
    private Employee employee;

}
