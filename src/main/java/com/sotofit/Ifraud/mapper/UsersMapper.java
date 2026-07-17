package com.sotofit.Ifraud.mapper;

import static java.lang.Boolean.TRUE;

import com.sotofit.Ifraud.dtos.UserRequestById;
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

	public Users toEntity(UserRequestById usersRequestById) {
		Users userReq = new Users();
		userReq.setId(usersRequestById.getId());
		return userReq;
	}
}
