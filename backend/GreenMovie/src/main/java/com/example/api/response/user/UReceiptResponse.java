package com.example.api.response.user;

import java.util.List;

import com.example.api.response.BaseResponse;
import com.example.dtos.user.UReceiptDTO;

public class UReceiptResponse extends BaseResponse<UReceiptDTO>{

	public UReceiptResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UReceiptResponse(boolean isOK, String message, List<UReceiptDTO> data) {
		super(isOK, message, data);
		// TODO Auto-generated constructor stub
	}

	public UReceiptResponse(boolean isOK, String message) {
		super(isOK, message);
		// TODO Auto-generated constructor stub
	}

}
