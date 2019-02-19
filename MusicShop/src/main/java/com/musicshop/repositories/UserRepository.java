package com.musicshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musicshop.entities.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	User findByEmail(String email);

}
