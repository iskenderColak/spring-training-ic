package com.icolak.entity;

import com.icolak.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Table(name = "payments")
@NoArgsConstructor
@Getter
@Setter
public class Payment extends BaseEntity{

    private BigDecimal amount;

    @Column(columnDefinition = "DATE")
    private LocalDate createdDate;

    @Enumerated(EnumType.STRING)
    private Status paymentStatus;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;

    // @OneToOne(cascade = CascadeType.ALL)
    // when we try to do any action in the parent(Payment),
    // same action is ganna happen int the child(Payment Details)
    // When we save or remove payment, paymentDetail is ganna be saved or removed automatically
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "payment_detail_id")
    private PaymentDetail paymentDetail;

    public Payment(LocalDate createdDate, BigDecimal amount, Status paymentStatus) {
        this.amount = amount;
        this.createdDate = createdDate;
        this.paymentStatus = paymentStatus;
    }
}
