package com.example.services.admin;

import com.example.api.response.admin.CinemaResponse;
import com.example.dtos.admin.CinemaDTO;

public interface ICinemaService {
	CinemaResponse findAll();
	CinemaResponse findOne(Long id);
	CinemaResponse save(CinemaDTO dto);
	CinemaResponse delete(Long[] ids);
}
