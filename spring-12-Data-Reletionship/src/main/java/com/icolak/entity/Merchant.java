package com.icolak.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "merchants")
@NoArgsConstructor
@Getter
@Setter
public class Merchant extends BaseEntity{

    private String name;
    private String code;
    private Integer payoutDelayCount;
    private BigDecimal commissionRate;
    private BigDecimal transactionFee;
}
