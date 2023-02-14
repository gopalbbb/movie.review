package com.movies.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.dao.Moviedao;
import com.movies.entity.Movies;
@Service
public class MovieServiceImp implements MoviesService {
@Autowired
Moviedao moviedao;

	
	@Override
	public List<Movies> viewAllmovies() {
		List<Movies> movies=moviedao.findAll();
		return movies;
	}
	@Override
	public void addMovie(String movie_name, Date release_date, byte image) {
		Movies movie=new Movies();
		movie.setMovieName(movie_name);
		movie.setReleaseDate(release_date);
		movie.setImage(null);
		moviedao.save(movie);
		
	}
	
	public void saveImage(Movies movies) {
		moviedao.save(movies);
	}
	public Optional<Movies> getImageById(Integer movie_id) {
		return moviedao.findById(movie_id);
				
	}
	public List<Movies> getAllMovie() {
		return moviedao.findAll();
	}

}
