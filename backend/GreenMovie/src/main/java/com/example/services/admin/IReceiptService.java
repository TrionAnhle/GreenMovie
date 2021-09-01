package com.example.services.admin;

import com.example.api.response.admin.ReceiptResponse;
import com.example.dtos.admin.DashboardDTO;
import com.example.dtos.admin.ReceiptDTO;

public interface IReceiptService {
	ReceiptResponse findAll();
	ReceiptResponse findOne(Long id);
	ReceiptResponse updateStatusReceipt(ReceiptDTO dto);
	DashboardDTO getTotalInfo ();
}
