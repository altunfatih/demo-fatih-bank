package com.fatih.bank.db.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fatih.bank.db.model.Account;

@Component
public class AccountDao {
	
	private static List<Account> db = new ArrayList<>();

}
