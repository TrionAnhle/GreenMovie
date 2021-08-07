package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cinema")
public class CinemaEntity extends BaseEntity{
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "type")
	private Integer type;
	
	@Column(name = "number_seats", nullable = false)
	private Integer numberSeats;
	
	@Column(name = "price", nullable = false)
	private Long price;
	
	@OneToMany(mappedBy = "cinema")
	private List<SessionEntity> sessions = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getNumberSeats() {
		return numberSeats;
	}

	public void setNumberSeats(Integer numberSeats) {
		this.numberSeats = numberSeats;
	}

	public List<SessionEntity> getSessions() {
		return sessions;
	}

	public void setSessions(List<SessionEntity> sessions) {
		this.sessions = sessions;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
	
	
	
}
