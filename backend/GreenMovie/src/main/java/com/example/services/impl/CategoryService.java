package com.example.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.common.category.CategoryResponse;
import com.example.constants.AppConstants;
import com.example.dtos.CategoryDTO;
import com.example.entity.CategoryEntity;
import com.example.repositories.ICategoryRepository;
import com.example.services.ICategoryService;
import com.example.uitities.StringUtities;

@Service
public class CategoryService implements ICategoryService{
	
	@Autowired
	private ICategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryResponse findAll() {
		List<CategoryEntity> entities = categoryRepository.findAll();
		List<CategoryDTO> dtos = new ArrayList<>();
		for(CategoryEntity e : entities) {
			CategoryDTO dto = modelMapper.map(e, CategoryDTO.class);
			dtos.add(dto);
		}
		return new CategoryResponse(true,"",dtos);
	}

	@Override
	public CategoryResponse findOne(Long id) {
		CategoryEntity entity = categoryRepository.findById(id).orElse(null);
		if(entity == null)
			return new CategoryResponse(false,"Không tìm thấy dữ liệu");
		CategoryDTO dto = modelMapper.map(entity, CategoryDTO.class);
		return new CategoryResponse(true,"", Arrays.asList(dto));
	}

	@Override
	public CategoryResponse save(CategoryDTO dto) {
		dto.setCode(StringUtities.toCode(dto.getName()));
		CategoryEntity entity = categoryRepository.findOneByCode(dto.getCode());
		if(entity == null)
			return new CategoryResponse(false,"Tên bị trùng");
		
		entity = modelMapper.map(dto, CategoryEntity.class);
		categoryRepository.save(entity);
		return new CategoryResponse(true,AppConstants.SAVE_SUCCESS);
		
	}

	@Override
	public CategoryResponse update(CategoryDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryResponse delete(Long[] ids) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
