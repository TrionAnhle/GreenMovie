package com.example.dtos.user;

import java.util.Date;
import java.util.List;

import com.example.constants.ETypeCinema;

public class UReceiptDTO {
	private Long id;
	private Integer paymentType;
	private Date paymentDate;
	private Boolean isGetTicket;
	private Long customerId;
	private Long sessionId;
	private USessionDTO session;
	private Date createdDate;
	
	private String movieName;
	private Date showTime;
	private Integer cinemaName;
	private ETypeCinema cinemaType;
	private Long cinemaPrice;
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
	public USessionDTO getSession() {
		return session;
	}
	public void setSession(USessionDTO session) {
		this.session = session;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Date getShowTime() {
		return showTime;
	}
	public void setShowTime(Date showTime) {
		this.showTime = showTime;
	}
	public Integer getCinemaName() {
		return cinemaName;
	}
	public void setCinemaName(Integer cinemaName) {
		this.cinemaName = cinemaName;
	}
	public ETypeCinema getCinemaType() {
		return cinemaType;
	}
	public void setCinemaType(ETypeCinema cinemaType) {
		this.cinemaType = cinemaType;
	}
	public Long getCinemaPrice() {
		return cinemaPrice;
	}
	public void setCinemaPrice(Long cinemaPrice) {
		this.cinemaPrice = cinemaPrice;
	}
	
	
}
