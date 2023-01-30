package com.movies.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.movies.entity.Movies;
import com.movies.services.MoviesService;

@Controller
@RequestMapping("/movies")
public class MovieController {
	
final static Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	MoviesService movieService;
	
	@GetMapping("/create")
	public String addMovie() {
		return "create";
		
	}
	
	
	
	@PostMapping("/create")
	public String addMovie( @RequestParam(value="movie_name") String movie_name,  
			 
			@RequestParam(value="release_date") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date release_date) 
		 {
		movieService.addMovie(movie_name,release_date);
		
	
		
		return "success";
		
	}
	@GetMapping("/list")
	public String list(Model model) {
		logger.info("Inside get list method.....");
		
		List<Movies> movies =movieService.viewAllmovies();
		logger.info(movies.toString());
		model.addAttribute("movies", movies);
		return "moviesList";
		
	}
	
	
	
	
	
	
}
	
