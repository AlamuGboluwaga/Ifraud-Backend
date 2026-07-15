package com.sotofit.Ifraud.mapper;

import com.sotofit.Ifraud.dtos.CustomerAccountNumberResponseDto;
import com.sotofit.Ifraud.entities.CustomerOnboarding;
import org.springframework.stereotype.Component;

@Component
public class CustomerAccountNumberResponseMapper {

	public CustomerAccountNumberResponseDto toDto(CustomerOnboarding entity) {
		CustomerAccountNumberResponseDto dto = new CustomerAccountNumberResponseDto();
        dto.setFirstName(entity.getFirstName());
        dto.setSurName(entity.getSurName());
        dto.setEmail(entity.getEmail());
        dto.setAccountNumber(entity.getAccountNumber());
        dto.setBalance(entity.getBalance());
        dto.setId(entity.getId());
		return dto;
	}
}

// another way to implement Mapper
//
//import org.mapstruct.Mapper;
//
//@Mapper(componentModel = "spring")
//public interface CustomerAccountNumberResponseMapper {
//    // MapStruct automatically detects matching field names and writes the mapping for you!
//    CustomerAccountNumberResponseDto toDto(CustomerOnboarding entity);
//}