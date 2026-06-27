package com.sotofit.Ifraud.services;

import com.sotofit.Ifraud.entities.RegisterUser;
import com.sotofit.Ifraud.repositories.RegisterUserRepository;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class RegisterUserService {

	private RegisterUserRepository registerUserRepository;

	public RegisterUserService(RegisterUserRepository registerUserRepository) {
		this.registerUserRepository = registerUserRepository;
	}

	public List<RegisterUser> getAllRegisteredUser() {
		List<RegisterUser> user = registerUserRepository.findAll();
		return user;
	}

	public RegisterUser registerUser(RegisterUser registerUser) {
		return registerUserRepository.save(registerUser);
	}

	@GetMapping("/registered-user/{id}")
	public RegisterUser getRegisteredUserById(UUID id) {
		return registerUserRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
	}
}
