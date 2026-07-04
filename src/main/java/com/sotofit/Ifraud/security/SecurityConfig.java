package com.sotofit.Ifraud.security;

import com.sotofit.Ifraud.entities.RegisterUser;
import org.springframework.boot.micrometer.observation.autoconfigure.ObservationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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

	@Bean
	public SecurityFilterChain springSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(configurer ->
			configurer
				.requestMatchers(HttpMethod.GET, "/api/**")
				.hasRole("EMPLOYER")
				.requestMatchers(HttpMethod.POST, "/api/**")
				.hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "/api/**")
				.hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "/api/**")
				.hasAnyRole("ADMIN")
		);
		return null;
	}
}
