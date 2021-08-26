package com.example.dtos.user;

import java.util.List;

public class UMovieDTO {
	private Long id;
	private String name;
	private String description;
	private String pathThumbnail;
	private String pathVideo;
	private Integer screenTime;
	private Boolean isShowing;
	private List<UCategoryDTO> category;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPathThumbnail() {
		return pathThumbnail;
	}
	public void setPathThumbnail(String pathThumbnail) {
		this.pathThumbnail = pathThumbnail;
	}
	public String getPathVideo() {
		return pathVideo;
	}
	public void setPathVideo(String pathVideo) {
		this.pathVideo = pathVideo;
	}
	public Integer getScreenTime() {
		return screenTime;
	}
	public void setScreenTime(Integer screenTime) {
		this.screenTime = screenTime;
	}
	public Boolean getIsShowing() {
		return isShowing;
	}
	public void setIsShowing(Boolean isShowing) {
		this.isShowing = isShowing;
	}
	public List<UCategoryDTO> getCategory() {
		return category;
	}
	public void setCategory(List<UCategoryDTO> category) {
		this.category = category;
	}
	
	
}
