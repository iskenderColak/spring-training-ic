package com.icolak.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "items")
@NoArgsConstructor
@Getter
@Setter
public class Item extends BaseEntity{

    private String code;
    private String name;

    @ManyToMany(mappedBy = "items")
    private List<Cart> carts;

    public Item(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
