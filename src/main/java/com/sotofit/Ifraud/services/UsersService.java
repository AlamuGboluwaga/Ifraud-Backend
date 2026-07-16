package com.sotofit.Ifraud.services;

import com.sotofit.Ifraud.entities.Users;
import com.sotofit.Ifraud.repositories.UsersRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

	@Autowired
	private final UsersRepository usersRepository;

	public UsersService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	public Users createUser(Users users) {
		if (users == null) {
			return null;
		}
		return usersRepository.save(users);
	}

	public List<Users> getAllUsers() {
    var users  = usersRepository.findAll();
    if(users.isEmpty()){
        return  null;
    }
        return users;
	}
}
