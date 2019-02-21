package com.musicshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.musicshop.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
