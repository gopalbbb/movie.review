package com.movies.services;

import java.util.Date;
import java.util.List;

import com.movies.entity.Movies;

public interface MoviesService {
	public void addMovie(String movie_name,Date release_date,byte image);
	public List <Movies> viewAllmovies();

}
