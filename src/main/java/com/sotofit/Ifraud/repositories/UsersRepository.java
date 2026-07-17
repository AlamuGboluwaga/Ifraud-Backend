package com.sotofit.Ifraud.repositories;

import com.sotofit.Ifraud.entities.Users;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, UUID> {

    Optional<Users> findByEmail(String email);
}
