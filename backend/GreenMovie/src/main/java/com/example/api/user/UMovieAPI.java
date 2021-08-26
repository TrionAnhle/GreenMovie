package com.example.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.response.user.UMovieResponse;
import com.example.services.user.IUMovieService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController(value = "MovieOfUser")
@RequestMapping(value = "/api/public/movie")
public class UMovieAPI {
	@Autowired
	private IUMovieService movieService;
	
	@GetMapping
	public ResponseEntity<UMovieResponse> findAll(){
		UMovieResponse resp = movieService.findAll();
		return new ResponseEntity<UMovieResponse>(resp, HttpStatus.OK);
	}
	
	@GetMapping(value = "/is-showing")
	public ResponseEntity<UMovieResponse> findAllIsShowing(){
		UMovieResponse resp = movieService.findAllIsShowing();
		return new ResponseEntity<UMovieResponse>(resp, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UMovieResponse> findOne(@PathVariable(name = "id") long id){
		UMovieResponse resp = movieService.findOne(id);
		return new ResponseEntity<UMovieResponse>(resp, HttpStatus.OK);
	}
}
