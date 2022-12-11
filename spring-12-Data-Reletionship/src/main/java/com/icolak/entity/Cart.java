package com.icolak.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cart")
@NoArgsConstructor
@Getter
@Setter
public class Cart extends BaseEntity{

    @ManyToMany
    @JoinColumn(name = "cart_item_rel")
    private List<Item> item;
}
