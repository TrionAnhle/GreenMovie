package com.example.services.user;

import com.example.api.response.user.UCustomerResponse;

public interface IUCustomerService {
	UCustomerResponse findOneByUserName(String username);
}
