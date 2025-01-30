package com.sergio.fastservice.entity.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table (name = "users")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String username;

	@NotNull
	private String password;

	public UserEntity(Long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public UserEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public @NotNull String getUsername() {
		return username;
	}

	public void setUsername(@NotNull String username) {
		this.username = username;
	}

	public @NotNull String getPassword() {
		return password;
	}

	public void setPassword(@NotNull String password) {
		this.password = password;
	}

}
