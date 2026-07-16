package com.sotofit.Ifraud.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@NotBlank(message = "Id is required")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private UUID id;

	@NotNull(message = "Email is required")
	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@NotNull(message = "Phone is required")
	@Column(name = "phone", nullable = false, unique = true)
	private String phone;

	@NotNull(message = "Password is required")
	@Column(name = "password", nullable = false)
	private String password;

	@NotNull(message = "Role is required")
	@Column(name = "role", nullable = false)
	private String role;

	@NotNull(message = "Active is required")
	@Column(name = "is_active", nullable = false)
	private Boolean isActive;

	@NotBlank(message = "Created At is required")
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@NotBlank(message = "Updated At is required")
	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;

	public void User() {}

	public void User(
		String email,
		String phone,
		String password,
		String role,
		Boolean isActive,
		LocalDateTime createdAt,
		LocalDateTime updatedAt
	) {
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.role = role;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@PrePersist
	public void onCreate() {
		LocalDateTime date = LocalDateTime.now();
		this.createdAt = date;
		this.updatedAt = date;
	}

	@PreUpdate
	public void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getActive() {
		return isActive;
	}

	public void setActive(Boolean active) {
		isActive = active;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
