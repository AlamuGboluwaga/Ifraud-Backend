package com.sotofit.Ifraud.dtos;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public class UserRequestById {

	@NotNull(message = "User Id is required")
	private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
