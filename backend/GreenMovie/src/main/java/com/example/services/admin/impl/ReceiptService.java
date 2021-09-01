package com.example.services.admin.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.api.response.admin.ReceiptResponse;
import com.example.constants.AppConstants;
import com.example.dtos.TicketDTO;
import com.example.dtos.admin.DashboardDTO;
import com.example.dtos.admin.ReceiptDTO;
import com.example.entity.ReceiptEntity;
import com.example.entity.TicketEntity;
import com.example.repositories.IAccountRepository;
import com.example.repositories.IReceiptRepository;
import com.example.services.admin.IReceiptService;

@Service
public class ReceiptService implements IReceiptService{
	
	@Autowired
	private IReceiptRepository receiptRepository;
	
	@Autowired
	private IAccountRepository accountRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ReceiptResponse findAll() {
		List<ReceiptEntity> entities = receiptRepository.findAll();
		List<ReceiptDTO> dtos = new ArrayList<>();
		for (ReceiptEntity e : entities) {
			ReceiptDTO dto = modelMapper.map(e, ReceiptDTO.class);
			dto.setCustomerName(e.getCustomer().getFullName());
			dto.setCustomerPhone(e.getCustomer().getPhone());
			dtos.add(dto);
		}
		return new ReceiptResponse(true, "", dtos);
	}

	@Override
	public ReceiptResponse findOne(Long id) {
		ReceiptEntity entity = receiptRepository.findById(id).orElse(null);
		if (entity == null)
			return new ReceiptResponse(false, AppConstants.NOT_FOUND_DATA);
		ReceiptDTO dto = toDTO(entity);
		return new ReceiptResponse(true, "", Arrays.asList(dto));
	}

	@Override
	public ReceiptResponse updateStatusReceipt(ReceiptDTO dto) {
		ReceiptEntity entity = receiptRepository.findById(dto.getId()).orElse(null);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(entity == null)
			return new ReceiptResponse(false, AppConstants.NOT_FOUND_DATA);
		entity.setIsGetTicket(true);
		entity.setUpdateDate(new Date());
		entity.setUpdateBy(authentication.getName());
		receiptRepository.save(entity);
		return new ReceiptResponse(true, "Đã lấy vé thành công");
	}
	
	public ReceiptDTO toDTO(ReceiptEntity entity) {
		ReceiptDTO dto = new ReceiptDTO();
		
		dto = modelMapper.map(entity, ReceiptDTO.class);
		dto.setCustomerName(entity.getCustomer().getFullName());
		dto.setCustomerPhone(entity.getCustomer().getPhone());
		List<TicketDTO> listTicket = new ArrayList<>();
		for(TicketEntity i : entity.getTickets()) {
			TicketDTO ticket = new TicketDTO();
			
			ticket.setSeatId(i.getId().getSeatId());
			ticket.setMovie(i.getSession().getMovie().getName());
			ticket.setCinema(i.getSession().getCinema().getName());
			ticket.setShowTime(i.getSession().getShowTime());
			
			listTicket.add(ticket);
		}
		dto.setTickets(listTicket);
		return dto;
	}

	
	@Override
	public DashboardDTO getTotalInfo() {
		LocalDate currentDate = LocalDate.now(); 
		int m = currentDate.getMonth().getValue();
		int y = currentDate.getYear();
		DashboardDTO dto = new DashboardDTO();
		
		List<ReceiptEntity> entities;
		List<Long> profits = new ArrayList<>();
		List<Long> customersNew = new ArrayList<>();
		Long profit,numberTicket = 0L, customer = 0L;
		for(int i = 1; i<=m; i++) {
			profit = numberTicket = 0L;
			entities = receiptRepository.findAllInMonth(i, y);
			customer = accountRepository.countByRoleInMonth("ROLE_USER", i, y);
			if(i<m) {
				for(ReceiptEntity e : entities) {
					profit+=(e.getTickets().size()*e.getTickets().get(0).getPrice());
				}
			}else {
				for(ReceiptEntity e : entities) {
					profit+=(e.getTickets().size()*e.getTickets().get(0).getPrice());
					numberTicket+=(e.getTickets().size());
				}
			}
			customersNew.add(customer);
			profits.add(profit);
			
		}
		dto.setProfitMonth(profits.get(profits.size()-1));
		dto.setNewCustomer(customersNew.get(customersNew.size()-1));
		dto.setTicketBookedMonth(numberTicket);
		dto.setProfitEachMonth(profits);
		dto.setNewCustomerEachMonth(customersNew);
		return dto;
	}

}
