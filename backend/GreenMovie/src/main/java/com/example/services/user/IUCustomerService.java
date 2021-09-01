package com.example.services.user;

import com.example.api.response.user.UCustomerResponse;
import com.example.dtos.user.UCustomerDTO;

public interface IUCustomerService {
	UCustomerResponse findOneByUserName(String username);
	UCustomerResponse update(UCustomerDTO dto);
	UCustomerResponse updatePassword(UCustomerDTO dto);
}
