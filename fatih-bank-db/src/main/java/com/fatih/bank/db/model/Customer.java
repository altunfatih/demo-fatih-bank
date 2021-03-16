package com.fatih.bank.db.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import com.fatih.bank.db.model.enumaration.CustomerStatusType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer extends UserEntityBase {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CustomerStatusType status;

    @OneToMany(mappedBy = "customer")
    private Set<Account> accounts;

}