package com.example.dtos.user;

import java.util.Date;
import java.util.List;

public class USessionDTO {
	private Long id;
	private Date showTime;
	private Date finishTime;
	private UMovieDTO movie;
	private UCinemaDTO cinema;
	private List<Integer> lstTicket;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getShowTime() {
		return showTime;
	}
	public void setShowTime(Date showTime) {
		this.showTime = showTime;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public UMovieDTO getMovie() {
		return movie;
	}
	public void setMovie(UMovieDTO movie) {
		this.movie = movie;
	}
	public UCinemaDTO getCinema() {
		return cinema;
	}
	public void setCinema(UCinemaDTO cinema) {
		this.cinema = cinema;
	}
	public List<Integer> getLstTicket() {
		return lstTicket;
	}
	public void setLstTicket(List<Integer> lstTicket) {
		this.lstTicket = lstTicket;
	}
	
	
}
