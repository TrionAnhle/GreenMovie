package com.example.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.response.admin.CinemaResponse;
import com.example.dtos.admin.CinemaDTO;
import com.example.services.ICinemaService;

@RestController(value = "CinemaOfAdmin")
@RequestMapping(value = "/api/admin/cinema")
public class CinemaAPI {
	@Autowired
	private ICinemaService cinemaService;
	
	@GetMapping
	public ResponseEntity<CinemaResponse> findAll(){
		CinemaResponse resp = cinemaService.findAll();
		return new ResponseEntity<CinemaResponse>(resp, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CinemaResponse> findOne(@PathVariable(name = "id") long id){
		CinemaResponse resp = cinemaService.findOne(id);
		return new ResponseEntity<CinemaResponse>(resp, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CinemaResponse> saveCategory(@RequestBody CinemaDTO dto){
		CinemaResponse resp = cinemaService.save(dto);
		return new ResponseEntity<CinemaResponse>(resp, HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<CinemaResponse> deleteCategory(@RequestBody Long[] ids){
		CinemaResponse resp = cinemaService.delete(ids);
		return new ResponseEntity<CinemaResponse>(resp, HttpStatus.OK);
	}
}
