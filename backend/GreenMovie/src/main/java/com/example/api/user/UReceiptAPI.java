package com.example.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.response.user.UReceiptResponse;
import com.example.dtos.user.UReceiptDTO;
import com.example.services.user.IUReceiptService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController(value = "ReceiptrOfUser")
@RequestMapping(value = "/api/user/receipt")
public class UReceiptAPI {
	
	@Autowired
	private IUReceiptService receiptService;
	
	@PostMapping
	public ResponseEntity<UReceiptResponse> bookTicket(@RequestBody UReceiptDTO dto){
		UReceiptResponse resp = receiptService.save(dto);
		return new ResponseEntity<UReceiptResponse>(resp, HttpStatus.OK);
	}
	
}
