package com.movies.services;

import java.util.List;

import com.movies.entity.MovieReview;
import com.movies.entity.User;

public interface ReviewService {
	
	public void addReview(String comment,Integer rating_score,Integer movie_id,Integer user_id);
	


}
