package com.example.api.response.user;

import java.util.List;

import com.example.api.response.BaseResponse;
import com.example.dtos.user.UCustomerDTO;

public class UCustomerResponse extends BaseResponse<UCustomerDTO> {

	public UCustomerResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UCustomerResponse(boolean isOK, String message, List<UCustomerDTO> data) {
		super(isOK, message, data);
		// TODO Auto-generated constructor stub
	}

	public UCustomerResponse(boolean isOK, String message) {
		super(isOK, message);
		// TODO Auto-generated constructor stub
	}
	
}
