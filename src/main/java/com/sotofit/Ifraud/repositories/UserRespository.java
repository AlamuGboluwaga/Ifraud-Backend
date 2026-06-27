package com.sotofit.Ifraud.repositories;

import com.sotofit.Ifraud.entities.User;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends JpaRepository<User, UUID> {}
