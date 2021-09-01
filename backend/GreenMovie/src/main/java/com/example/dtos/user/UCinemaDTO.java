package com.example.dtos.user;

import com.example.constants.ETypeCinema;

public class UCinemaDTO {
	private Long id;
	private Integer name;
	private ETypeCinema type;
	private Integer numberSeats;
	private Long price;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getName() {
		return name;
	}
	public void setName(Integer name) {
		this.name = name;
	}
	public ETypeCinema getType() {
		return type;
	}
	public void setType(ETypeCinema type) {
		this.type = type;
	}
	public Integer getNumberSeats() {
		return numberSeats;
	}
	public void setNumberSeats(Integer numberSeats) {
		this.numberSeats = numberSeats;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	
	
}
