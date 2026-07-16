//package com.sotofit.Ifraud.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//	@Bean
//	public InMemoryUserDetailsManager userDetailsManager() {
//		UserDetails gboluwaga = User.builder().username("gboluwaga").password("{noop}password").roles("ADMIN").build();
//		UserDetails adeoye = User.builder().username("adeoye").password("{noop}password").roles("MANAGER").build();
//		UserDetails oluwatosin = User.builder().username("oluwatosin").password("{noop}passwords").roles("EMPLOYEE").build();
//
//		return new InMemoryUserDetailsManager(gboluwaga, adeoye, oluwatosin);
//	}
//
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests(auth ->
//			auth
//				.requestMatchers(HttpMethod.GET, "/api/ifraud/**")
//				.hasRole("EMPLOYEE")
//				.requestMatchers(HttpMethod.POST, "/api/ifraud/**")
//				.hasRole("MANAGER")
//				.requestMatchers(HttpMethod.PUT, "/api/ifraud/**")
//				.hasRole("MANAGER")
//				.requestMatchers(HttpMethod.DELETE, "/api/ifraud/**")
//				.hasRole("ADMIN")
//			.anyRequest()
//				.authenticated()
//		);
//
//		// use HTTP Basic Authentication
//		http.httpBasic(Customizer.withDefaults());
//		// disable Cross Site Request Forgery (CSRF)
//		// in general, not required for stateless REST API that use POST, PUT /OR PATCH, DELETE
//		http.csrf(csrf -> csrf.disable());
//		return http.build();
//	}
//}
