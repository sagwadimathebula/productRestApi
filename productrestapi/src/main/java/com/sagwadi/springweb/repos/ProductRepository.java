package com.sagwadi.springweb.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagwadi.springweb.modules.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
