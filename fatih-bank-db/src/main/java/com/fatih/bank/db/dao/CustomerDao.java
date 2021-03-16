package com.fatih.bank.db.dao;

import java.util.Optional;

import com.fatih.bank.db.model.Customer;

public interface CustomerDao {
	
    Optional<Customer> findByCitizenNumber(String citizenNumber);

    void save(Customer customer);
}
