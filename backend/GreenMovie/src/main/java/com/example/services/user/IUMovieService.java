package com.example.services.user;

import com.example.api.response.user.UMovieResponse;

public interface IUMovieService {
	UMovieResponse findOne(Long id);
	UMovieResponse findAll();
	UMovieResponse findAllIsShowing();
}
