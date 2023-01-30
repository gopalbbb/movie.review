package com.movies.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table
public class MovieReview {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer reviewId;
	private String comment;
	private Integer ratingScore;
	
	// for foreign key we have to give class name for datatype  which class is reference for here 
	@ManyToOne
	@JoinColumn(name="movie_id")
	
	// here movies id is foreign key  Movies class is reference so here datatype is Movies 
	private Movies movie;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Integer getReviweId() {
		return reviewId;
	}

	public void setReviweId(Integer reviweId) {
		this.reviewId = reviweId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getRatingScore() {
		return ratingScore;
	}

	public void setRatingScore(Integer ratingScore) {
		this.ratingScore = ratingScore;
	}

	public Movies getMovie() {
		return movie;
	}

	public void setMovie(Movies movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

}
