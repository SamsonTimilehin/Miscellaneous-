package com.example.queryingRepo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Office {

    @Id
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name="addressId", referencedColumnName="id"),
            @JoinColumn(name="addressZip", referencedColumnName="zip")
    })
    private Address address;
}
