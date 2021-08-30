package com.example.dtos.user;

import java.util.Date;

public class USessionDTO {
	private Long id;
	private Date showTime;
	private Date finishTime;
	private UMovieDTO movie;
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
	
}
