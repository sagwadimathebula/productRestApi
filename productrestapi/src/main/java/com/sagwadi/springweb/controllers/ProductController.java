package com.sagwadi.springweb.controllers;

import java.util.List;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sagwadi.springweb.modules.Product;
import com.sagwadi.springweb.repos.ProductRepository;




@RestController
public class ProductController {
	
	@Autowired
	ProductRepository repositorys;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
@RequestMapping(value = "/product",method = RequestMethod.GET)	
public List<Product> getProducts() {
	return repositorys.findAll();
}

@RequestMapping(value = "/product/{id}",method = RequestMethod.GET)
@Transactional(readOnly = true)
@Cacheable("product-cache")
public Product getProduct(@PathVariable("id") long id) {
	LOGGER.info("Finding product by ID" + id);
	return repositorys.findById(id).get();
}

@RequestMapping(value = "/product",method = RequestMethod.POST)
public Product createProduct(@RequestBody Product product) {
	return repositorys.save(product);
}

@RequestMapping(value = "/product",method = RequestMethod.PUT)
public Product UpdateProduct(@RequestBody Product product) {
	return repositorys.save(product);
}

@RequestMapping(value = "/product/{id}",method = RequestMethod.DELETE)
@CacheEvict("Product-cache")
public void DeleteProduct(@PathVariable("id") long id) {
 repositorys.deleteById(id);
}
}
