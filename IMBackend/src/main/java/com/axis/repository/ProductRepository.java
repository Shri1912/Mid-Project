package com.axis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axis.model.Product;



public interface ProductRepository extends JpaRepository<Product, Integer> {

}