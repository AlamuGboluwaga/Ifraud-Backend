package com.sotofit.Ifraud.services;

import com.sotofit.Ifraud.dtos.UserRequestByEmail;
import com.sotofit.Ifraud.dtos.UsersRequest;
import com.sotofit.Ifraud.dtos.UsersResponse;
import com.sotofit.Ifraud.mapper.UsersMapper;
import com.sotofit.Ifraud.repositories.UsersRepository;
import java.util.List;
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

		if (email == null) {
			throw new IllegalArgumentException("User id is required");
		}

		var user = usersRepository
			.findByEmail(email)
			.orElseThrow(() -> new IllegalArgumentException("User with " + email + " was not found"));

		return usersmapper.toDto(user);
	}
}
