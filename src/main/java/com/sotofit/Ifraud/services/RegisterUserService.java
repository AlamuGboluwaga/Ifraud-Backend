package com.sotofit.Ifraud.services;

import com.sotofit.Ifraud.dtos.RegisteredUserResponseDTO;
import com.sotofit.Ifraud.entities.RegisterUser;
import com.sotofit.Ifraud.mapper.RegisterMapper;
import com.sotofit.Ifraud.repositories.RegisterUserRepository;
import java.util.List;
import java.util.UUID;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterUserService {

	private final RegisterUserRepository registerUserRepository;

	//	@Autowired
	//	private PasswordEncoder passwordEncoder;

	public RegisterUserService(RegisterUserRepository registerUserRepository) {
		this.registerUserRepository = registerUserRepository;
	}

	public List<RegisteredUserResponseDTO> getAllRegisteredUser() {
		var users = registerUserRepository.findAll();

		var userDto = users.stream().map(RegisterMapper::registeredUserMapperDTO).toList();

		return userDto;
	}

	public RegisterUser registerUser(RegisterUser registerUser) {
		//		var user = registerUserRepository
		//			.findById(registerUser.getId())
		//			.orElseThrow(() -> new RuntimeException("User already exists"));
		//		user.setId(registerUser.getId());
		//		user.setFirstName(registerUser.getFirstName());
		//		user.setLastName(registerUser.getLastName());
		//		user.setEmail(registerUser.getEmail());

		//		String hashedPassword = passwordEncoder.encode(registerUser.getPassword());
		//		user.setPassword(hashedPassword);

		return registerUserRepository.save(registerUser);
	}

	public RegisterUser getRegisteredUserById(UUID id) {
		return registerUserRepository
			.findById(id)
			.orElseThrow(() -> new RuntimeException("User with id " + id + " was not found"));
	}

	public RegisterUser updateRegisteredUserBtId(RegisterUser registerUser, UUID id) {
		var user = registerUserRepository
			.findById(id)
			.orElseThrow(() -> new RuntimeException(" The user with " + id + " was not found"));
		user.setFirstName(registerUser.getFirstName());
		user.setLastName(registerUser.getLastName());
		user.setEmail(registerUser.getEmail());
		user.setPassword(registerUser.getPassword());

		return registerUserRepository.save(user);
	}

	@Transactional
	public void deleteRegisteredUserById(UUID id) {
		var user = registerUserRepository
			.findById(id)
			.orElseThrow(() -> new RuntimeException("User with id " + id + " was not found"));
		registerUserRepository.delete(user);
	}
}
