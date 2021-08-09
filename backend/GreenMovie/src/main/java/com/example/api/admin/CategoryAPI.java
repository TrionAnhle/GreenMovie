package com.example.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.common.category.CategoryResponse;
import com.example.dtos.admin.CategoryDTO;
import com.example.services.ICategoryService;

@RestController(value = "CategoryOfAdmin")
public class CategoryAPI {
	@Autowired
	private ICategoryService categoryService;
	
	@GetMapping(value = "/api/admin/category")
	public ResponseEntity<CategoryResponse> findAll(){
		CategoryResponse resp = categoryService.findAll();
		return new ResponseEntity<CategoryResponse>(resp, HttpStatus.OK);
	}
	
	@GetMapping(value = "/api/admin/category/{id}")
	public ResponseEntity<CategoryResponse> findOne(@PathVariable(name = "id") long id){
		CategoryResponse resp = categoryService.findOne(id);
		return new ResponseEntity<CategoryResponse>(resp, HttpStatus.OK);
	}
	
	@PostMapping(value = "/api/admin/category")
	public ResponseEntity<CategoryResponse> addCategory(@RequestBody CategoryDTO dto){
		CategoryResponse resp = categoryService.save(dto);
		return new ResponseEntity<CategoryResponse>(resp, HttpStatus.OK);
	}

}
