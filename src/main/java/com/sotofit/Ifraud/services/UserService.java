package com.sotofit.Ifraud.services;

import com.sotofit.Ifraud.entities.User;
import com.sotofit.Ifraud.repositories.UserRespository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private UserRespository userRespository;

	public UserService(UserRespository userRespository) {
        this.userRespository =userRespository;

    }

	public List<User> getAllUsers() {
		var user = userRespository.findAll();

		return user;
	}
}
