package com.icolak.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String make;
    private String model;

    // Since id is provided by Spring we can not put @AllArgsConstructor
    // We should create a constructor without id
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }
}
