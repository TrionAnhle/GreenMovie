package com.example.services.user.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.api.response.user.UReceiptResponse;
import com.example.dtos.user.UReceiptDTO;
import com.example.entity.CustomerEntity;
import com.example.entity.ReceiptEntity;
import com.example.entity.SessionEntity;
import com.example.entity.TicketEntity;
import com.example.entity.TicketId;
import com.example.repositories.ICustomerRepository;
import com.example.repositories.IReceiptRepository;
import com.example.repositories.ISessionRepository;
import com.example.repositories.ITicketRepository;
import com.example.services.user.IUReceiptService;

@Service
public class UReceiptService implements IUReceiptService{
	@Autowired
	private IReceiptRepository receiptRepository;
	
	@Autowired
	private ICustomerRepository customerRepository;
	
	@Autowired
	private ITicketRepository ticketRepository;
	
	@Autowired
	private ISessionRepository sessionRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	@Transactional
	public UReceiptResponse save(UReceiptDTO dto) {
		dto.setId(null);
		dto.setIsGetTicket(false);
		dto.setPaymentDate(new Date());
		ReceiptEntity entity = modelMapper.map(dto, ReceiptEntity.class);
		CustomerEntity customerEntity = customerRepository.findById(dto.getCustomerId()).orElse(null);
		SessionEntity sessionEntity = sessionRepository.findById(dto.getSessionId()).orElse(null);
		
		Boolean isBooked = false;
		StringBuilder message = new StringBuilder("Ghế ");
		for(Integer i : dto.getTickets()) {
			if(ticketRepository.existsById(new TicketId(sessionEntity.getId(), i))) {
				isBooked = true;
				message.append(String.valueOf(i)+",");
			}
		}
		if(isBooked) {
			String m = message.toString().substring(0, message.length() -1) +" đã được đặt";
			return new UReceiptResponse(false, m);		
		}
		if(customerEntity == null)
			return new UReceiptResponse(false, "Không có dữ liệu về người đặt");
		if(sessionEntity == null)
			return new UReceiptResponse(false, "Không có dữ liệu về suất chiếu");
		entity.setCustomer(customerEntity);		
		entity = receiptRepository.save(entity);
		// Save ticket to receipt
		for(Integer i : dto.getTickets()) {
			TicketEntity ticket = new TicketEntity();
			ticket.setId(new TicketId(sessionEntity.getId(), i));
			ticket.setPrice(sessionEntity.getCinema().getPrice());
			ticket.setSession(sessionEntity);
			ticket.setReceipt(entity);
			ticketRepository.save(ticket);
			
		}		
		return new UReceiptResponse(true, "Đặt thành công");
	}
	
}
