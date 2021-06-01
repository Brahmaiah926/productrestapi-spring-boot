package com.cganna.springweb.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cganna.springweb.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
