package com.movies.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movies.entity.MovieReview;
@Repository
public interface MovieReviewdao extends JpaRepository<MovieReview,Integer>{

}
