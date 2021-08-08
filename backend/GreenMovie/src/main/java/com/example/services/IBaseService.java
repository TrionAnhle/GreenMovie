package com.example.services;

public interface IBaseService<R,D> {
	R findAll();
	R findOne(Long id);
	R save(D dto);
	R update(D dto);
	R delete(Long[] ids);
}
