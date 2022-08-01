package com.sagwadi.springweb;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.sagwadi.springweb.modules.Product;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductrestapiApplicationTests {
	@Value("${productrestapi.service.url}")
	private String Base_Url;

	@Test
	void testGetProduct() {
		System.out.println(Base_Url);
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(Base_Url +"/6", Product.class);
		assertNotNull(product);
		assertEquals("mac", product.getName());
	}
	
	@Test
	public void testCreatedProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = new Product();
		product.setName("Hisense");
		product.setPrice(900);
		product.setDescription("Smart television");
		Product response = restTemplate.postForObject(Base_Url, product, Product.class);
		assertNotNull(response);
		assertNotNull(response.getId());
		assertEquals("Hisense", response.getName());
	}
	
	@Test
	public void testUpdateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(Base_Url+"/7", Product.class);
		product.setPrice(14000);
		restTemplate.put(Base_Url, product);
		
	}

}
