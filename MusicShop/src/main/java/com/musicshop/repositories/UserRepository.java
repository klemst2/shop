package com.musicshop.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musicshop.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

	Optional<User> findByEmail(String email);

	Optional<User> findByName(String name);

}
