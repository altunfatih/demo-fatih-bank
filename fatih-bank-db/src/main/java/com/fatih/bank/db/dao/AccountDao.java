package com.fatih.bank.db.dao;

import java.util.Optional;

import com.fatih.bank.db.model.Account;

public interface AccountDao {

    int countByCustomerId(Long customerId);

    void save(Account entity);

    Optional<Account> findById(Long accountId);
  
}
