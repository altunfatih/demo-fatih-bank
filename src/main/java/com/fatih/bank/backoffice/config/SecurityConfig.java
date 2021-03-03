package com.fatih.bank.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fatih.bank.service.MyUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailService myService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests()
	        	.antMatchers("/css/**", "/js/**", "/img/**" )
	        		.permitAll()
	        	.anyRequest()
	        		.authenticated()
	        	.and()
	        		.formLogin()
	        		.loginPage("/login")
	        		.permitAll()
	        	.and()
	        		.logout()
	        		.logoutUrl("/logout")
	        		.logoutSuccessUrl("/login?logout")
	        		.permitAll()
	        	.and()
	        	.userDetailsService(myService);
	        	;
	        	
	 }
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}