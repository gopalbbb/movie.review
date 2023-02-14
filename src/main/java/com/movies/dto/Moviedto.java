package com.movies.dto;

import java.util.Date;

public class Moviedto {
	
	private Integer movieId;
	private String movieName;
	private Date releaseDate;
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
		
	}
	public Moviedto(Integer movieId, String movieName, Date releaseDate) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.releaseDate = releaseDate;
	}
	
	
	
	
	
	

}
