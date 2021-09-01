package com.example.services.user.impl;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.api.response.user.UCustomerResponse;
import com.example.constants.AppConstants;
import com.example.dtos.user.UCustomerDTO;
import com.example.entity.AccountEntity;
import com.example.entity.CustomerEntity;
import com.example.repositories.IAccountRepository;
import com.example.services.user.IUCustomerService;

@Service
public class UCustomerService implements IUCustomerService{
	@Autowired
	private IAccountRepository accountRepository;
	
	@Autowired
	PasswordEncoder encoder;

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

	@Override
	@Transactional
	public UCustomerResponse update(UCustomerDTO dto) {
		AccountEntity entity = accountRepository.findById(dto.getId()).orElse(null);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(entity == null)
			return new UCustomerResponse(false, AppConstants.NOT_FOUND_DATA);
		CustomerEntity customerEntity = entity.getCustomer();
		customerEntity.setEmail(dto.getEmail());
		customerEntity.setFullName(dto.getFullName());
		customerEntity.setPhone(dto.getPhone());
		customerEntity.setSex(dto.getSex());
		customerEntity.setAddress(dto.getAddress());
		entity.setCustomer(customerEntity);
		entity.setUpdateDate(new Date());
		entity.setUpdateBy(authentication.getName());
		accountRepository.save(entity);
		return new UCustomerResponse(true,AppConstants.UPDATE_SUCCESS);
	}

	@Override
	public UCustomerResponse updatePassword(UCustomerDTO dto) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		AccountEntity entity = accountRepository.findById(dto.getId()).orElse(null);
		if(entity == null)
			return new UCustomerResponse(false, AppConstants.NOT_FOUND_DATA);
		if(!entity.getUsername().trim().equals(authentication.getName().trim()))
			return new UCustomerResponse(false, "Không được quyền đổi mật khẩu");
		entity.setPassword(encoder.encode(dto.getPassword()));
		accountRepository.save(entity);
		return new UCustomerResponse(true,"Đổi mật khẩu thành công");
	}

}
