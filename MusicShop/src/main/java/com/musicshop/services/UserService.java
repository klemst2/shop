package com.musicshop.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.musicshop.entities.Role;
import com.musicshop.entities.User;
import com.musicshop.repositories.RoleRepository;
import com.musicshop.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void createUser(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Role userRole = new Role("USER");
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);
	}

	public void createAdmin(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Role userRole = new Role("ADMIN");
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);
	}

	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public boolean userEmailExist(String email) {
		return userRepository.findByEmail(email).isPresent();
	}

	public boolean userNameExist(String name) {
		return userRepository.findByName(name).isPresent();
	}

	public void deleteUserById(Long id) {
		findById(id).ifPresent(user -> userRepository.delete(user));
	}
}
