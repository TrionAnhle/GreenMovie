package com.example.services.user.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.response.user.USessionResponse;
import com.example.dtos.user.UMovieDTO;
import com.example.dtos.user.USessionDTO;
import com.example.dtos.user.USessionTimeDTO;
import com.example.entity.SessionEntity;
import com.example.repositories.ISessionRepository;
import com.example.services.user.IUSessionService;

@Service
public class USessionService implements IUSessionService{
	@Autowired
	private ISessionRepository sessionRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public USessionResponse findAllSessionInDay(USessionTimeDTO dto) {
		if(dto.getDate() == null || dto.getDate().equals(""))
			return new USessionResponse(false,"Dữ liệu thiếu");
		StringBuilder start = new StringBuilder();
		if(dto.getTime() == null || dto.getTime().trim().equals("")) {
			start.append(dto.getDate().trim() + " 00:00:00");
		}else {
			start.append(dto.getDate().trim() + " "+dto.getTime().trim());
		}
		StringBuilder end = new StringBuilder(dto.getDate() + " 23:59:59");
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startTime, endTime;
		try {
			startTime = formatter.parse(start.toString());
			endTime = formatter.parse(end.toString());
		} catch (ParseException e) {
			return new USessionResponse (false, "Sai định dạng thời gian yyyy-MM-dd HH:mm:ss");
		}
		List<SessionEntity> entities = sessionRepository.findAllSessionInDay(startTime, endTime);
		List<USessionDTO> dtos = new ArrayList<>();
		for(SessionEntity e : entities) {
			USessionDTO d = toDTO(e);
			dtos.add(d);
		}
		return new  USessionResponse (true,"",dtos);
	}
	
	public USessionDTO toDTO(SessionEntity e) {
		USessionDTO d = new USessionDTO();
		d.setId(e.getId());
		d.setShowTime(e.getShowTime());
		d.setFinishTime(e.getFinishTime());
		UMovieDTO mDto = new UMovieDTO();
		mDto.setId(e.getMovie().getId());
		mDto.setName(e.getMovie().getName());
		mDto.setPathThumbnail(e.getMovie().getPathThumbnail());
		d.setMovie(mDto);
		return d;
	}
}
