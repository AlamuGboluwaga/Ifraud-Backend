package com.sotofit.Ifraud.services;

import com.sotofit.Ifraud.entities.RegisterUser;
import com.sotofit.Ifraud.repositories.RegisterUserRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService {

	private RegisterUserRepository registerUserRepository;

	public RegisterUserService(RegisterUserRepository registerUserRepository) {
		this.registerUserRepository = registerUserRepository;
	}

	public List<RegisterUser> getAllRegisteredUser() {
		return registerUserRepository.findAll();
	}
}
