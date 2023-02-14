package com.movies.entity;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
	@Lob
	@Column(name="image",length=Integer.MAX_VALUE)
	private byte[]image;
	
	
	@OneToMany(cascade=CascadeType.ALL,targetEntity=MovieReview.class,mappedBy="movie")
	//holding multiple Datatype using list 
	List<MovieReview>reviews;
	
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
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
	@Override
	public String toString() {
		return "Movies [movieId=" + movieId + ", movieName=" + movieName + ", releaseDate=" + releaseDate + ", image="
				+ Arrays.toString(image) + ", reviews=" + reviews + "]";
	}
	

	
	
	
	
	
}
