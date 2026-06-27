package com.sotofit.Ifraud.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public class RegisteredUserDTO {

	private String firstName;

	private String lastName;

	private String email;
}
