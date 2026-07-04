package com.sotofit.Ifraud.mapper;

import com.sotofit.Ifraud.dtos.RegisteredUserResponseDTO;
import com.sotofit.Ifraud.entities.RegisterUser;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class RegisterMapper {

	public static RegisteredUserResponseDTO registeredUserMapperDTO(RegisterUser registerUser) {

        RegisteredUserResponseDTO registeredUserResponseDTO = new RegisteredUserResponseDTO();

        registeredUserResponseDTO.setFirstName(registerUser.getFirstName());
        registeredUserResponseDTO.setLastName(registerUser.getLastName());
        registeredUserResponseDTO.setEmail(registerUser.getEmail());
        return registeredUserResponseDTO;
	}
}
