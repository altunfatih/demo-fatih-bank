package com.fatih.bank.db.model;

import java.math.BigDecimal;

import com.fatih.bank.db.model.enumaration.AccountCurrency;
import com.fatih.bank.db.model.enumaration.AccountStatusType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private Long id;
    
    // ManyToOne
    private Customer customer;
    
    private String accountNumber;
    
    private String accountName;
    
    private String description;
    
    private BigDecimal balance;
    
    // @Enumarated
    private AccountCurrency currency;
    
    // @Enumarated
    private AccountStatusType status;
}
