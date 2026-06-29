package com.sotofit.Ifraud.repositories;

import com.sotofit.Ifraud.entities.RegisterUser;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterUserRepository extends JpaRepository<RegisterUser, UUID> {}


//public interface RegisterUserRepository extends JpaRepository<RegisterUser, UUID> {}
//public interface RegisterUserRepository implement JpaRepository<RegisterUser, UUID> {}