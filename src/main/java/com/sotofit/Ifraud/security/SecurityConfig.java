package com.sotofit.Ifraud.security;

import com.sotofit.Ifraud.entities.RegisterUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		UserDetails gboluwaga = User.builder().username("gboluwaga").password("{noop}password").roles("ADMIN").build();
		UserDetails adeoye = User.builder().username("adeoye").password("{noop}password").roles("MANAGER").build();
		UserDetails oluwatosin = User
			.builder()
			.username("oluwatosin")
			.password("{noop}password")
			.roles("EMPLOYEE")
			.build();

		return new InMemoryUserDetailsManager(gboluwaga, adeoye, oluwatosin);
	}


}
