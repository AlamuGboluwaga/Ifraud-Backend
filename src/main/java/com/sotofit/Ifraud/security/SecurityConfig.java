package com.sotofit.Ifraud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain basicAuth(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth ->
			auth.requestMatchers("/api/ifraud/**").permitAll().anyRequest().authenticated()
		).httpBasic(Customizer.withDefaults());

		return http.build();
	}
}
