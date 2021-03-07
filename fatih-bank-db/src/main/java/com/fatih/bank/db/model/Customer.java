package com.fatih.bank.db.model;

import com.fatih.bank.db.model.enumaration.CustomerStatusType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Customer extends UserEntityBase {

    private CustomerStatusType status;

   // private List<Account> accounts = new ArrayList<>();

}