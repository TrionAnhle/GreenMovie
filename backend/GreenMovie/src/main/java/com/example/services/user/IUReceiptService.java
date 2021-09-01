package com.example.services.user;

import com.example.api.response.user.UReceiptResponse;
import com.example.dtos.user.UReceiptDTO;

public interface IUReceiptService {
	UReceiptResponse findAllByCustomer(Long id);
	UReceiptResponse save(UReceiptDTO dto);
}	
