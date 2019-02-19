package com.musicshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musicshop.entities.Role;

public interface RoleRepository extends JpaRepository<Role, String>{
	

}
