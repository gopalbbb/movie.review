package com.movies.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table
public class Movies {
	@Id
	// multiple generation type is available we can use different with situation look UUID
	
	// self Referencing  in cascade VVI
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer movieId;
	private String movieName;
	private Date releaseDate;
	//one movie has multiple review so use one to many
	
	
	@OneToMany(cascade=CascadeType.ALL,targetEntity=MovieReview.class,mappedBy="movie")
	//holding multiple Datatype using list 
	List<MovieReview>reviews;
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
	

	
	
	
	
	
}
