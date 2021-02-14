package com.fatih.bank.db.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;

import org.springframework.stereotype.Component;

import com.fatih.bank.db.model.Employee;

@Component
public class EmployeeDao {

	private List<Employee> db = new ArrayList<Employee>();

	public void add(Employee employee) {
		OptionalLong maxOption = db.stream().mapToLong(e -> e.getId()).max();
		long id;
		
		if (maxOption.isEmpty())
			id = 1;
		else 
			id = maxOption.getAsLong() + 1;
		
		employee.setId(id);
		db.add(employee);
	}

	public Object findAll() {
		
		return db;
	}
		
}
