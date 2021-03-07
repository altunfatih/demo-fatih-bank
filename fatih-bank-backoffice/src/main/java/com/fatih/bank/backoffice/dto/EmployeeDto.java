package com.fatih.bank.backoffice.dto;

import com.fatih.bank.db.model.Employee;

import lombok.Data;

@Data
public class EmployeeDto extends Employee {
	
	private String confirmPassword;
}
