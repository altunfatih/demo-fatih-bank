package com.fatih.bank.backoffice.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fatih.bank.service.RestoreDBService;

@Controller
public class LoginController {
	
	@Autowired
	private RestoreDBService restoreDBService;

	
	@GetMapping("/login")
	public String  girisPage(Model model, Principal user) {
		if (user != null) {
			return "redirect:/";
		}
		
		restoreDBService.checkEmptyDB();
		
		return "user/login";
	}
	
}