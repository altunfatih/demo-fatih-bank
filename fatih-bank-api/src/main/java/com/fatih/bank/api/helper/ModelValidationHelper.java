package com.fatih.bank.api.helper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.fatih.bank.db.dao.AccountDao;
import com.fatih.bank.db.dao.CustomerDao;
import com.fatih.bank.db.model.Account;
import com.fatih.bank.db.model.Customer;

@Component
public class ModelValidationHelper {

    @Autowired
    private CustomerDao customerDao;
    
    @Autowired
    private AccountDao accountDao;
    

    public Optional<Customer> findAndCheckCustomer(String citizenNumber) {
        Optional<Customer> existingCustomer = customerDao.findByCitizenNumber(citizenNumber);
        if(existingCustomer.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                 "Given citizen number not found " + citizenNumber
            );
        }
        return existingCustomer;
    }
    
    public Account findAndCheckAccount(Long accountId) {
        Optional<Account> dbAccount = accountDao.findById(accountId);
        if (dbAccount.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Given account not found with account id: " + accountId);
        }
        return dbAccount.get();
    }
}