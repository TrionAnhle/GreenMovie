package com.example.dtos.user;

import java.util.Date;
import java.util.List;

public class UReceiptDTO {
	private Long id;
	private Integer paymentType;
	private Date paymentDate;
	private Boolean isGetTicket;
	private Long customerId;
	private Long sessionId;
	private List<Integer> tickets;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Boolean getIsGetTicket() {
		return isGetTicket;
	}
	public void setIsGetTicket(Boolean isGetTicket) {
		this.isGetTicket = isGetTicket;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public List<Integer> getTickets() {
		return tickets;
	}
	public void setTickets(List<Integer> tickets) {
		this.tickets = tickets;
	}
	public Long getSessionId() {
		return sessionId;
	}
	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}	
	
}
