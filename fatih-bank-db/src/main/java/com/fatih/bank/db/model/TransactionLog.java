package com.fatih.bank.db.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fatih.bank.db.model.enumaration.TransactionLogType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class TransactionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    private Account account;
    
    @ManyToOne
    private Account toAccount;
    
    @Column(nullable = false)
    private BigDecimal amount;
    
    @Column(nullable = false)
    private BigDecimal balance;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionLogType type;
    
    @Column(nullable = false)
    private LocalDate date;
    
    private String description;
    
}
