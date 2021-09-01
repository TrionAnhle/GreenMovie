package com.example.dtos.user;

import java.util.ArrayList;
import java.util.List;

public class UCustomerDTO {
	private Long id;
	private String fullName;
	private String password;
	private Boolean sex;
	private String phone;
	private String address;
	private String email;
	List<UReceiptDTO> receipts = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Boolean getSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<UReceiptDTO> getReceipts() {
		return receipts;
	}
	public void setReceipts(List<UReceiptDTO> receipts) {
		this.receipts = receipts;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
