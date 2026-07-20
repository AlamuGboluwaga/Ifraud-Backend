package com.sotofit.Ifraud.services;

import com.sotofit.Ifraud.ErrorHandler.ResourceNotFoundException;
import com.sotofit.Ifraud.dtos.UserRequestByEmail;
import com.sotofit.Ifraud.dtos.UserUpdateRequest;
import com.sotofit.Ifraud.dtos.UsersRequest;
import com.sotofit.Ifraud.dtos.UsersResponse;
import com.sotofit.Ifraud.entities.Users;
import com.sotofit.Ifraud.mapper.UsersMapper;
import com.sotofit.Ifraud.repositories.UsersRepository;
import java.util.List;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

	private final UsersRepository usersRepository;
	private final UsersMapper usersmapper;

	public UsersService(UsersRepository usersRepository, UsersMapper usersmapper) {
		this.usersRepository = usersRepository;
		this.usersmapper = usersmapper;
	}

	public UsersResponse createUser(UsersRequest request) {
		var entity = usersmapper.toEntity(request);
		var saved = usersRepository.save(entity);

		return usersmapper.toDto(saved);
	}

	public List<UsersResponse> getAllUsers() {
		var entity = usersRepository.findAll();

		return entity.stream().map(usersmapper::toDto).toList();
	}

	public UsersResponse getUserByEmail(UserRequestByEmail requestByEmail) {
		String email = requestByEmail.getEmail();
		System.out.println("emailAddress " + email);
		if (email.isBlank()) {
			throw new IllegalArgumentException("User email is required");
		}

		var user = usersRepository.findByEmail(email).orElseThrow(()->new ResourceNotFoundException());

		return usersmapper.toDto(user);
	}

	public UsersResponse updateByEmail(UserUpdateRequest userUpdateRequest, String email) {
		if (email == null) {
			throw new IllegalArgumentException("User id is required");
		}
		//b808aaba-997a-43a3-a946-e8bd1f1e9c32
		var user = usersRepository
			.findByEmail(email)
			.orElseThrow(() -> new IllegalArgumentException("User with " + email + " was not found"));

		Users users = new Users();
		users.setId(user.getId());
		users.setFirstname(userUpdateRequest.getFirstname());
		users.setPhone(userUpdateRequest.getPhone());
		users.setPassword(userUpdateRequest.getPassword());
		users.setRole(userUpdateRequest.getRole());
		users.setUpdatedAt(userUpdateRequest.getUpdatedAt());
		users.setActive(userUpdateRequest.getActive());

		usersRepository.save(users);
		return usersmapper.toDto(users);
	}
}
