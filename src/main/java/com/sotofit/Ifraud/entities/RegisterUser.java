package com.sotofit.Ifraud.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "register_users", indexes = @Index(name = "email", columnList = "email", unique = true))
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@NotBlank
	@Column(name = "first_name", nullable = false)
	private String firstName;

	@NotBlank
	@Column(name = "last_name", nullable = false)
	private String lastName;

	@NotBlank
	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@NotNull(message = "Password is required")
	@Column(name = "password", nullable = false)
	private String password;

	@NotBlank
	@Column(name = "role", nullable = false)
	private String role;

	@NotNull(message = "Active is required")
	@Column(name = "is_active", nullable = false)
	private Boolean isActive;
}
