package com.example.services.user.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.response.user.UMovieResponse;
import com.example.constants.AppConstants;
import com.example.dtos.user.UCategoryDTO;
import com.example.dtos.user.UMovieDTO;
import com.example.entity.CategoryEntity;
import com.example.entity.MovieEntity;
import com.example.repositories.IMovieRepository;
import com.example.services.user.IUMovieService;

@Service
public class UMovieService implements IUMovieService{
	@Autowired
	private IMovieRepository movieRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UMovieResponse findOne(Long id) {
		MovieEntity entity = movieRepository.findById(id).orElse(null);
		if(entity == null)
			return new UMovieResponse(false, AppConstants.NOT_FOUND_DATA);
		UMovieDTO dto = modelMapper.map(entity, UMovieDTO.class);
		//Add category
		List<UCategoryDTO> listCategory = new ArrayList<UCategoryDTO>();
		for(CategoryEntity e : entity.getCategories()) {
			UCategoryDTO cDto = modelMapper.map(e, UCategoryDTO.class);
			listCategory.add(cDto);
		}
		dto.setCategory(listCategory);		
		return new UMovieResponse(true,"",Arrays.asList(dto));
	}

	@Override
	public UMovieResponse findAll() {
		List<MovieEntity> entities  = movieRepository.findAll();
		return new UMovieResponse(true,"",this.toDTO(entities));
	}
	
	public List<UMovieDTO> toDTO(List<MovieEntity> entities){
		List<UMovieDTO> dtos = new ArrayList<>();
		for(MovieEntity e : entities) {
			UMovieDTO dto = new UMovieDTO();
			dto = modelMapper.map(e, UMovieDTO.class);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public UMovieResponse findAllIsShowing() {
		List<MovieEntity> entities  = movieRepository.findAllIsShowing();
		return new UMovieResponse(true,"",this.toDTO(entities));
	}
	
}
