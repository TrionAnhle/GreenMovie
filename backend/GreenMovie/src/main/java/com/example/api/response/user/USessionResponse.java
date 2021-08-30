package com.example.api.response.user;

import java.util.List;

import com.example.api.response.BaseResponse;
import com.example.dtos.user.USessionDTO;

public class USessionResponse extends BaseResponse<USessionDTO>{

	public USessionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public USessionResponse(boolean isOK, String message, List<USessionDTO> data) {
		super(isOK, message, data);
		// TODO Auto-generated constructor stub
	}

	public USessionResponse(boolean isOK, String message) {
		super(isOK, message);
		// TODO Auto-generated constructor stub
	}
	
	

}
