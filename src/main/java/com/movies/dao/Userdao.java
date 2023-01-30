package com.movies.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movies.entity.User;
@Repository
public interface Userdao extends JpaRepository<User,Integer>{

}
