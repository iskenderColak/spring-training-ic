package com.icolak.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "employee_from_dummy_api")
public class Employee {

    @Id
    private String id;
    private String title;
    private String firstName;
    private String lastName;
    private String picture;
}
