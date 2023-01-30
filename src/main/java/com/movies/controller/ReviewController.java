package com.movies.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.movies.entity.Movies;
import com.movies.entity.User;
import com.movies.services.MoviesService;
import com.movies.services.ReviewService;
import com.movies.services.UserService;
@Controller
@RequestMapping("/movies")
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	@Autowired
	MoviesService moviesService;
	@Autowired
	UserService userService;
	
	@GetMapping("/review")
	
	public String movieReview(Model model) {
		
		List<Movies>movies=moviesService.viewAllmovies();
		model.addAttribute("movies",movies);
		List<User>users=userService.viewAlluser();
		model.addAttribute("users",users);
		return"review";
		
	}
	
	
	
	@PostMapping("/review")
	public String movieReview(Model model,@RequestParam(value="comment") String comment,
			@RequestParam(value="rating_Score") Integer rating_Score,
			@RequestParam(value="movie_id") Integer movie_id,
			@RequestParam(value="user_id") Integer user_id) {
		List<String>error=new ArrayList<String>();
	if(comment ==null ||comment.isEmpty()||comment.isBlank()) {
		error.add("comment can't be empty or null");
	
	}else if(rating_Score == null||rating_Score <1 || rating_Score >10) {
		error.add("rating most between 1 up to 10");
		}
	if(error.size()>0) {
		model.addAttribute("errormsg",error);
		List<Movies>movies=moviesService.viewAllmovies();
		model.addAttribute("movies",movies);
		List<User>users=userService.viewAlluser();
		model.addAttribute("users",users);
		return"review";
	}
	
	
	
	
	
	
	reviewService.addReview(comment, rating_Score, movie_id, user_id);
	return "thankyou";
	}
}
	
