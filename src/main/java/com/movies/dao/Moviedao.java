package com.movies.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movies.entity.Movies;
@Repository
public interface Moviedao extends JpaRepository <Movies,Integer> {

}
