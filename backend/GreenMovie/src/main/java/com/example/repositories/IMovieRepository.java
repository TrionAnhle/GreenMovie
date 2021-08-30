package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.MovieEntity;

@Repository
public interface IMovieRepository extends JpaRepository<MovieEntity, Long>{
	
	@Query("From MovieEntity m Where m.isShowing = true")
	List<MovieEntity> findAllIsShowing();
	
	
}
