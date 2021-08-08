package com.example.api.common.category;

import java.util.List;

import com.example.api.common.BaseResponse;
import com.example.dtos.CategoryDTO;

public class CategoryResponse extends BaseResponse<CategoryDTO>{

	public CategoryResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryResponse(boolean isOK, String message, List<CategoryDTO> data) {
		super(isOK, message, data);
		// TODO Auto-generated constructor stub
	}

	public CategoryResponse(boolean isOK, String message) {
		super(isOK, message);
		// TODO Auto-generated constructor stub
	}
	
}
