package com.sotofit.Ifraud.mapper;

import com.sotofit.Ifraud.dtos.RegisteredUserResponseDto;
import com.sotofit.Ifraud.entities.RegisterUser;
import lombok.Getter;
import lombok.Setter;

public class RegisterMapper {

	public static RegisteredUserResponseDto registeredUserMapperDTO(RegisterUser registerUser) {
		RegisteredUserResponseDto dto = new RegisteredUserResponseDto();
		dto.setId(registerUser.getId());
		dto.setFirstName(registerUser.getFirstName());
		dto.setLastName(registerUser.getLastName());
		dto.setEmail(registerUser.getEmail());
		dto.setIsActive(registerUser.getIsActive());
		return dto;
	}
}
