package com.fatih.bank.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatih.bank.api.dto.AccountListDto;
import com.fatih.bank.api.dto.AccountSaveDto;
import com.fatih.bank.db.model.Customer;

@RestController
@RequestMapping(AccountApi.API_ACCOUNT_BASE_URL)
public class AccountApi {

	public static final String API_ACCOUNT_BASE_URL = "/api/account";
	
	@GetMapping("/list")
	public List<Object> listAll() {
		Customer customer = null;
		
		return null;
	}
	
    @PostMapping("/create")
    public Long create(@RequestBody AccountSaveDto newAccountDto) {
        return null;
    }
    
    @GetMapping("/getInfo")
    public AccountListDto getInfo(@RequestBody Long accountId) {
        return null;
    }
    
    @PostMapping("/close")
    public AccountListDto close(@RequestBody Long accountId) {
        return null;
    }
}
