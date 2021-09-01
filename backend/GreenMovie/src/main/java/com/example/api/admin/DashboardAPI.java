package com.example.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dtos.admin.DashboardDTO;
import com.example.services.admin.IReceiptService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController(value = "DashboardOfAdmin")
@RequestMapping(value = "/api/admin/dashboard")
public class DashboardAPI {
	@Autowired
	private IReceiptService receiptService;
	
	@GetMapping
	public ResponseEntity<DashboardDTO> findAllInfo() {
		DashboardDTO resp = receiptService.getTotalInfo();
		return new ResponseEntity<DashboardDTO>(resp, HttpStatus.OK);
	}

}
