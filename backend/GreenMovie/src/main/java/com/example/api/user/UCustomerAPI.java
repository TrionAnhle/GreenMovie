package com.example.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.response.user.UCustomerResponse;
import com.example.dtos.user.UCustomerDTO;
import com.example.dtos.user.UCustomerGetDTO;
import com.example.services.user.IUCustomerService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController(value = "CustomerOfUser")
@RequestMapping(value = "/api/user/customer")
public class UCustomerAPI {

	@Autowired
	private IUCustomerService customerService;
	
	@PostMapping(value = "/username")
	public ResponseEntity<UCustomerResponse> findOne(@RequestBody UCustomerGetDTO dto){
		UCustomerResponse resp = customerService.findOneByUserName(dto.getUsername());
		return new ResponseEntity<UCustomerResponse>(resp, HttpStatus.OK);
	}
	
	@PostMapping(value = "/info")
	public ResponseEntity<UCustomerResponse> update(@RequestBody UCustomerDTO dto){
		UCustomerResponse resp = customerService.update(dto);
		return new ResponseEntity<UCustomerResponse>(resp, HttpStatus.OK);
	}
	
	@PostMapping(value = "/password")
	public ResponseEntity<UCustomerResponse> resetPassword(@RequestBody UCustomerDTO dto){
		UCustomerResponse resp = customerService.updatePassword(dto);
		return new ResponseEntity<UCustomerResponse>(resp, HttpStatus.OK);
	}
	
}
