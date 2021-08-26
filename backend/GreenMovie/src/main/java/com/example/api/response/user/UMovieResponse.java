package com.example.api.response.user;

import java.util.List;

import com.example.api.response.BaseResponse;
import com.example.dtos.user.UMovieDTO;

public class UMovieResponse extends BaseResponse<UMovieDTO>{

	public UMovieResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UMovieResponse(boolean isOK, String message, List<UMovieDTO> data) {
		super(isOK, message, data);
		// TODO Auto-generated constructor stub
	}

	public UMovieResponse(boolean isOK, String message) {
		super(isOK, message);
		// TODO Auto-generated constructor stub
	}
	

}
