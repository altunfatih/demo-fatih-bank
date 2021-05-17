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

import com.fatih.bank.db.model.enumaration.AccountCurrency;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ExchangeRate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private LocalDate date;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private AccountCurrency currency;

	@Column(nullable = false)
	private BigDecimal rate;

}