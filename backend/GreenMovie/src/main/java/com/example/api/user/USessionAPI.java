package com.example.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.response.user.USessionResponse;
import com.example.dtos.user.USessionTimeDTO;
import com.example.services.user.IUSessionService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController(value = "SessionOfUser")
@RequestMapping(value = "/api/public/session")
public class USessionAPI {
	@Autowired
	private IUSessionService sessionService;
	
	@PostMapping(value = "/inday")
	public ResponseEntity<USessionResponse> findAllIsShowing(@RequestBody USessionTimeDTO dto){
		USessionResponse resp = sessionService.findAllSessionInDay(dto);
		return new ResponseEntity<USessionResponse>(resp, HttpStatus.OK);
	}
	
}
