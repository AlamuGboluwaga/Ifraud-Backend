package com.sotofit.Ifraud.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@NotBlank
	@Column(name = "first_name", nullable = false)
	private String firstName;


	@NotBlank
    @Email(message = "Invalid email format")
	@Column(name = "email", nullable = false, unique = true)
	private String email;

    @NotBlank
    @Column(name = "role", nullable = false)
    private String role;


	@NotNull
	@Column(name = "password", nullable = false)
	private String password;
}
