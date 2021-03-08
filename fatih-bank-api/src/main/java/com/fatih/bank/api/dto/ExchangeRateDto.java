package com.fatih.bank.api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExchangeRateDto {

    private LocalDate date;
    
    private String currency;
    
    private BigDecimal rate;
}
