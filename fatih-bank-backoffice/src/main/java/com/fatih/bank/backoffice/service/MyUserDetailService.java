package com.fatih.bank.backoffice.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fatih.bank.db.dao.EmployeeDao;
import com.fatih.bank.db.model.Employee;

@Service
public class MyUserDetailService  implements UserDetailsService {

	@Autowired
	private EmployeeDao employeeDao;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Employee emp = employeeDao.findByEmail(email);
        if (emp == null){
            throw new UsernameNotFoundException("Invalid username or password...");
        }
        return new org.springframework.security.core.userdetails.User(emp.getEmail(),
                emp.getPassword(),
                Arrays.asList( new SimpleGrantedAuthority(emp.getRole().name())));
        
	}
	

}