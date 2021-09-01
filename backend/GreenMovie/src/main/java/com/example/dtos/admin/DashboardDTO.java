package com.example.dtos.admin;

import java.util.List;

public class DashboardDTO {
	private Long ticketBookedMonth;
	private Long profitMonth;
	private Long newCustomer;
	private List<Long> profitEachMonth;
	private List<Long> newCustomerEachMonth;
	public Long getTicketBookedMonth() {
		return ticketBookedMonth;
	}
	public void setTicketBookedMonth(Long ticketBookedMonth) {
		this.ticketBookedMonth = ticketBookedMonth;
	}
	public Long getProfitMonth() {
		return profitMonth;
	}
	public void setProfitMonth(Long profitMonth) {
		this.profitMonth = profitMonth;
	}
	public Long getNewCustomer() {
		return newCustomer;
	}
	public void setNewCustomer(Long newCustomer) {
		this.newCustomer = newCustomer;
	}
	public List<Long> getProfitEachMonth() {
		return profitEachMonth;
	}
	public void setProfitEachMonth(List<Long> profitEachMonth) {
		this.profitEachMonth = profitEachMonth;
	}
	public List<Long> getNewCustomerEachMonth() {
		return newCustomerEachMonth;
	}
	public void setNewCustomerEachMonth(List<Long> newCustomerEachMonth) {
		this.newCustomerEachMonth = newCustomerEachMonth;
	}
	
	
	
}
