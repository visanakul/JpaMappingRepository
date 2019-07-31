package com.mapping.jpa.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mapping.jpa.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Serializable> {

}
