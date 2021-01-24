package com.cake.manager.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
		
	   @Bean
	    @Override
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }
	   
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	  http
	    		  .csrf().disable()
	    		  .authorizeRequests()
	    	      .anyRequest()
	    	      .authenticated()
	    	      .and()
	    	      .oauth2Login();
	   
	    }
	   	     
}

