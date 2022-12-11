package com.icolak.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "item")
@NoArgsConstructor
@Getter
@Setter
public class Item extends BaseEntity{

    private String code;
    private String name;
}
