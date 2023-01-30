package com.movies.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.dao.MovieReviewdao;
import com.movies.dao.Moviedao;
import com.movies.dao.Userdao;
import com.movies.entity.MovieReview;
import com.movies.entity.Movies;
import com.movies.entity.User;
@Service
public class ReviewSerciveImp implements ReviewService {
	
	@Autowired
	MovieReviewdao movieReviewdao;
	@Autowired
	Moviedao moviesdao;
	@Autowired
	Userdao userdao;
	

	@Override
	public void addReview(String comment, Integer rating_score, Integer movie_id, Integer user_id) {
		MovieReview movieReview = new MovieReview();
		movieReview.setComment(comment);
		movieReview.setRatingScore(rating_score);
		Movies movie = moviesdao.findById(movie_id).get();
		movieReview.setMovie(movie);
		User user=userdao.findById(user_id).get();
		movieReview.setUser(user);
		movieReviewdao.save(movieReview);
		
	}

}
