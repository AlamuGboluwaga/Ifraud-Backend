package com.sotofit.Ifraud.mapper;

import com.sotofit.Ifraud.dtos.UserRequestByEmail;
import com.sotofit.Ifraud.dtos.UsersRequest;
import com.sotofit.Ifraud.dtos.UsersResponse;
import com.sotofit.Ifraud.entities.Users;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class UsersMapper {

	public Users toEntity(UsersRequest request) {
		Users userReq = new Users();
		userReq.setFirstname(request.getFirstname());
		userReq.setEmail(request.getEmail());
		userReq.setPhone(request.getPhone());
		userReq.setPassword(request.getPassword());
		userReq.setRole("USER");
		userReq.setActive(true);
		userReq.setCreatedAt(LocalDateTime.now());
		userReq.setUpdatedAt(LocalDateTime.now());

		return userReq;
	}

	public UsersResponse toDto(Users users) {
		UsersResponse userRes = new UsersResponse();
		userRes.setId(users.getId());
		userRes.setFirstName(users.getFirstname());
		userRes.setEmail(users.getEmail());
		userRes.setPhone(userRes.getPhone());
		userRes.setRole("USER");
		userRes.setActive(true);
		userRes.setCreatedAt(users.getCreatedAt());

		return userRes;
	}

	public Users toEntity(UserRequestByEmail usersRequestByEmail) {
		Users userReq = new Users();
		userReq.setEmail(usersRequestByEmail.getEmail());
		return userReq;
	}
}
