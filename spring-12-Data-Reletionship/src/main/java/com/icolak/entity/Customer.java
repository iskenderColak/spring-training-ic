package com.icolak.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@Getter
@Setter
public class Customer extends BaseEntity{

    private String name;
    private String surName;
    private String userName;
    private String email;
    private String address;
}
