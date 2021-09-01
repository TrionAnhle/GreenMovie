package com.example.services.user.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.api.response.user.UCustomerResponse;
import com.example.constants.AppConstants;
import com.example.dtos.user.UCustomerDTO;
import com.example.entity.AccountEntity;
import com.example.repositories.IAccountRepository;
import com.example.services.user.IUCustomerService;

@Service
public class UCustomerService implements IUCustomerService{
	@Autowired
	private IAccountRepository accountRepository;

	@Override
	public UCustomerResponse findOneByUserName(String username) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		AccountEntity accountE = accountRepository.findByUsername(username).orElse(null);
		if(!authentication.getName().trim().equals(username.trim()))
			return new UCustomerResponse(false, "Không có quyền truy cập");
		if(accountE == null)
			return new UCustomerResponse(false, AppConstants.NOT_FOUND_DATA);	
		if(accountE.getCustomer() == null)
			return new UCustomerResponse(false, "Không phải tài khoản người dùng");
		UCustomerDTO dto = toDTOFroAccountEntity(accountE);
		return new UCustomerResponse(true,"",Arrays.asList(dto));
	}
	
	public UCustomerDTO toDTOFroAccountEntity(AccountEntity entity) {
		UCustomerDTO dto = new UCustomerDTO();
		dto.setId(entity.getId());
		dto.setFullName(entity.getCustomer().getFullName());
		dto.setSex(entity.getCustomer().getSex());
		dto.setPhone(entity.getCustomer().getPhone());
		dto.setAddress(entity.getCustomer().getAddress());
		dto.setEmail(entity.getCustomer().getEmail());
		return dto;
	}

}
