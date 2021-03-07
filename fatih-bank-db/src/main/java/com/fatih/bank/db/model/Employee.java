package com.fatih.bank.db.model;

import com.fatih.bank.db.model.enumaration.EmployeeRoleType;
import com.fatih.bank.db.model.enumaration.EmployeeStatusType;

import lombok.Data;

@Data
public class Employee extends UserEntityBase {
	
    private EmployeeStatusType status;
    
    private EmployeeRoleType role = EmployeeRoleType.USER;

}