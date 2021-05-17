package com.fatih.bank.api.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fatih.bank.db.model.enumaration.AccountCurrency;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExchangeTransactionDto {

    @NotNull
    private Long accountId;
    
    private AccountCurrency currency;
    
    @Min(value = 1)
    private BigDecimal count;
    
}
