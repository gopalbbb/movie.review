package com.movies.services;



public interface ReviewService {
	
	public void addReview(String comment,Integer rating_score,Integer movie_id,Integer user_id);

}
