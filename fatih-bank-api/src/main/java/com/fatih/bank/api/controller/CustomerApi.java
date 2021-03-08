package com.fatih.bank.api.controller;

import java.security.Principal;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatih.bank.api.dto.CustomerListDto;
import com.fatih.bank.api.dto.CustomerSaveDto;
import com.fatih.bank.db.model.Customer;

@RestController
@RequestMapping(CustomerApi.API_CUSTOMER_BASE_URL)
public class CustomerApi {

    static final String API_CUSTOMER_BASE_URL = "/api/customer";

    @Autowired
    private ModelMapper modelMapper;
    
    @PostMapping("/register")
    private Long add(@RequestBody CustomerSaveDto customerSaveDto) {
        
        Customer customer = modelMapper.map(customerSaveDto, Customer.class);
        
        return null;
    }
    
    @PutMapping("/update")
    private boolean update(@RequestBody CustomerSaveDto customerSaveDto, Principal user) {
        return false;
    }
    
    @GetMapping("/getInfo")
    private CustomerListDto getInfo(Principal user) {
        return null;
    }
}
