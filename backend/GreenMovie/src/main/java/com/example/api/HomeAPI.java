package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.uitities.UploadFileUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController(value = "HomeAPI")
@RequestMapping(value = "/api/public/home")
public class HomeAPI {
	@Autowired
	private UploadFileUtils files;
	
	@GetMapping(value = "/slide")
	public ResponseEntity<List<String>> findImageSlide(){
		List<String> slides = files.getImageSlide();
		return new ResponseEntity<List<String>>(slides, HttpStatus.OK);
	}

}
