package com.fatih.bank.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fatih.bank.api.dto.AccountListDto;
import com.fatih.bank.api.dto.AccountSaveDto;
import com.fatih.bank.db.dao.AccountDao;
import com.fatih.bank.db.dao.CustomerDao;
import com.fatih.bank.db.model.Account;
import com.fatih.bank.db.model.Customer;
import com.fatih.bank.db.model.enumaration.AccountStatusType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(AccountApi.API_ACCOUNT_BASE_URL)
public class AccountApi {

    public static final String API_ACCOUNT_BASE_URL = "/api/account";

    @Autowired
    private CustomerDao customerDao;
    
    @Autowired
    private AccountDao accountDao;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @GetMapping("/list")
    public List<AccountListDto> listAll(String citizenNumber){
        
        Optional<Customer> existingCustomer = findAndCheckCustomer(citizenNumber);
        
        List<AccountListDto> accountListDto = new ArrayList<>();
        Set<Account> dbAccounts = existingCustomer.get().getAccounts();
        for (Account account : dbAccounts) {
            AccountListDto convertedDto = convertToDto(account);
            accountListDto.add(convertedDto); 
        }
        
        /*--
        // Yukaridaki for dongusunun java stream hali
        List<AccountListDto> accountListDto = dbAccounts
            .stream()
            .map( acc -> modelMapper.map(acc, AccountListDto.class) )
            .collect(Collectors.toList());
         */
        
        return accountListDto;
    }

    @PostMapping("/create/{citizenNumber}")
    public Long create(
            @PathVariable("citizenNumber") String citizenNumber, 
            @RequestBody AccountSaveDto newAccountDto
    ) {
        Optional<Customer> existingCustomer = findAndCheckCustomer(citizenNumber);
        
        Account dbAccount = modelMapper.map(newAccountDto, Account.class);
        dbAccount.setCustomer(existingCustomer.get());
        
        Long customerId = existingCustomer.get().getId();
        int existingAccountCount = accountDao.countByCustomerId(customerId);
        String accountNumber = String.format("%07d-%02d", customerId, existingAccountCount+1 );
        dbAccount.setAccountNumber(accountNumber);
        
        accountDao.save(dbAccount);
        
        log.info("Account added with {} id", dbAccount.getId());
        
        return dbAccount.getId();
    }
    
    @GetMapping("/getInfo")
    public AccountListDto getInfo(Long accountId) {
        Account dbAccount = findAndCheckAccount(accountId);
        return convertToDto(dbAccount);
    }

    @PostMapping("/close")
    public AccountListDto close(@RequestBody Long accountId) {
        Account dbAccount = findAndCheckAccount(accountId);
        dbAccount.setStatus(AccountStatusType.CLOSED);
        accountDao.save(dbAccount);
        return convertToDto(dbAccount);
    }
    
    
    // *****************************************************************
    // HELPER METHOD(S)
    // *****************************************************************
    
    private AccountListDto convertToDto(Account dbAccount) {
        return modelMapper.map(dbAccount, AccountListDto.class);
    }

    private Optional<Customer> findAndCheckCustomer(String citizenNumber) {
        Optional<Customer> existingCustomer = customerDao.findByCitizenNumber(citizenNumber);
        if(existingCustomer.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                 "Given citizen number not found " + citizenNumber
            );
        }
        return existingCustomer;
    }
    
    private Account findAndCheckAccount(Long accountId) {
        Optional<Account> dbAccount = accountDao.findById(accountId);
        if (dbAccount.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Given account not found with account id: " + accountId);
        }
        return dbAccount.get();
    }
}