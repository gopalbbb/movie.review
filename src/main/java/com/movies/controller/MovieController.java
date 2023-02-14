package com.movies.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.movies.entity.Movies;
import com.movies.services.MovieServiceImp;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/movies")
public class MovieController {
	final static Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	
	@Autowired
	MovieServiceImp movieServiceImp;
	@Value("${uploadDir}")
	private String uploadFolder;
	
	
	@GetMapping("/create")
	public String addMovie() {
		return "create";
		
	}
	
	
	@PostMapping("/create")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public @ResponseBody ResponseEntity<?>addMovie(@RequestParam(value="movie_name") String movie_name,
			@RequestParam(value="release_date") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date release_date, Model model, HttpServletRequest request
			,final @RequestParam("image") MultipartFile file) {
		try {
			//String uploadDirectory = System.getProperty("user.dir") + uploadFolder;
			String uploadDirectory = request.getServletContext().getRealPath(uploadFolder);
			logger.info("uploadDirectory:: " + uploadDirectory);
			String fileName = file.getOriginalFilename();
			String filePath = Paths.get(uploadDirectory, fileName).toString();
			logger.info("FileName: " + file.getOriginalFilename());
			if (fileName == null || fileName.contains("..")) {
				model.addAttribute("invalid", "Sorry! Filename contains invalid path sequence \" + fileName");
				return new ResponseEntity<>("Sorry! Filename contains invalid path sequence " + fileName, HttpStatus.BAD_REQUEST);
			}
			String[] names = movie_name.split(",");
			Date relaseDate = new Date();
			logger.info("Name: " + names[0]+" "+filePath);
			try {
				File dir = new File(uploadDirectory);
				if (!dir.exists()) {
					logger.info("Folder Created");
					dir.mkdirs();
				}
				// Save the file locally
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
				stream.write(file.getBytes());
				stream.close();
			} catch (Exception e) {
				logger.info("in catch");
				e.printStackTrace();
			}
			byte[] imageData = file.getBytes();
			Movies movies = new Movies();
			movies.setMovieName(movie_name);
			movies.setReleaseDate(relaseDate);
			movies.setImage(imageData);
			
			movieServiceImp.saveImage(movies);
			
			
			logger.info("HttpStatus===" + new ResponseEntity<>(HttpStatus.OK));
			return new ResponseEntity<>("Product Saved With File - " + fileName, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception: " + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping("/image/display/{id}")
	@ResponseBody
	void showImage(@PathVariable("movie_id") Integer movie_id, HttpServletResponse response, Optional<Movies> movies)
			throws ServletException, IOException {
		logger.info("movie_id:: " + movie_id);
		movies =movieServiceImp.getImageById(movie_id); 
				
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(movies.get().getImage());
		response.getOutputStream().close();
	}

	@GetMapping("/movies/movieDetails")
	String showMovieDetails(@RequestParam("movie_id")Integer movie_id, Optional<Movies> movies, Model model) {
		try {
			logger.info("Id :: " +movie_id);
			if (movie_id != 0) {
				movies=movieServiceImp.getImageById(movie_id);
				
			
				logger.info("movie :: " + movies);
				if (movies.isPresent()) {
					model.addAttribute("movie_id", movies.get().getMovieId());
					model.addAttribute("movie_name", movies.get().getMovieName());
					model.addAttribute("release_date", movies.get().getReleaseDate());

					return "movieDetails";
				}
				return "redirect:/home";
			}
		return "redirect:/home";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/home";
		}	
	}

	@GetMapping("/list")
	@PreAuthorize("hasAuthority('ROLE_USER','ROLE_ADMIN')")
	String show(Model map) {
		List<Movies> movies = movieServiceImp.getAllMovie();
		map.addAttribute("movies", movies);
		return "images";
	}
}	
	


	
	/*@Autowired
	MoviesService movieService;
	
	@GetMapping("/create")
	public String addMovie() {
		return "create";
		
	}
	
	
	public String usingDto() {
		return null;
	}
	
	
	
	
	 * @PostMapping("/create") public String
	 * addMovie( @RequestParam(value="movie_name") String movie_name,
	 * 
	 * @RequestParam(value="release_date") @DateTimeFormat(iso=DateTimeFormat.ISO.
	 * DATE) Date release_date) { movieService.addMovie(movie_name,release_date,);
	 * 
	 * 
	 * 
	 * return "success";
	 * 
	 * }
	 
	@GetMapping("/list")
	public String list(Model model) {
		logger.info("Inside get list method.....");
		
		List<Movies> movies =movieService.viewAllmovies();
		logger.info(movies.toString());
		model.addAttribute("movies", movies);
		return "moviesList";
		
	}

}
	*/
