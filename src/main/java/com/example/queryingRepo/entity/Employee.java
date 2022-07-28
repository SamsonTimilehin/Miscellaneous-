package com.example.queryingRepo.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @CreationTimestamp
    private Date createdAt;
    private String role;
    @Column(unique = true)

    private String email;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Email> emails;

    private double amount;
}
