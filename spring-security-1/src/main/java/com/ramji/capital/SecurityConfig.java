/**
 * 
 */
package com.ramji.capital;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author HP
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
   
	/*
	 * @Autowired private DataSource datasource;
	 */
	// This method is responsible, how to authenticate user
	// by In memory
	// by JDBC
	// By Ldap or by any other way
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		  auth.inMemoryAuthentication() .withUser("ramji") 
		  // {noop} for pasword encoder
		   .password("{noop}passwd") 
		   .roles("USER") 
		   .and() 
		   .withUser("rohan")
		  .password("{noop}password") 
		  .roles("ADMIN") ;
		 
		
		/*
		 * auth.jdbcAuthentication().dataSource(datasource)
		 * .usersByUsernameQuery("select username, password, enabled" +
		 * " from users where username=?")
		 * .authoritiesByUsernameQuery("select username, authority " +
		 * "from authorities where username=?") .passwordEncoder(new
		 * BCryptPasswordEncoder());
		 */
		
	}
	
	// This method provide, security for each reuqest, customized request
	// based on ROLE
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/user/sayhello").permitAll()
		.antMatchers("/user/secure").hasRole("ADMIN")
		.and()
		.httpBasic();
		
		//http.authorizeRequests()
		//.anyRequest()
		//.authenticated()
		//.and()
		//.httpBasic();
	}
	
}
