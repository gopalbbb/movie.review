package com.movies.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.dao.Moviedao;
import com.movies.entity.Movies;
@Service
public class MovieServiceImp implements MoviesService {
@Autowired
Moviedao moviedao;
	@Override
	public void addMovie(String movie_name, Date release_date) {
		Movies movie =new Movies();
		movie.setMovieName(movie_name);
		movie.setReleaseDate(release_date);
		
		moviedao.save(movie);
		
		
		
	}
	@Override
	public List<Movies> viewAllmovies() {
		List<Movies> movies=moviedao.findAll();
		return movies;
	}

}
