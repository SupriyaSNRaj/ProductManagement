package com.skillsoft.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skillsoft.springboot.dto.ProductDto;
import com.skillsoft.springboot.exception.ProductNotFoundException;
import com.skillsoft.springboot.model.Product;
import com.skillsoft.springboot.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public List<ProductDto> getAllProducts(){
		
		return productService.getAllProducts();
	
	}
	
	@GetMapping("/products/{pId}")
	public Product getProduct(@PathVariable("pId") int id) {
		return productService.getProduct(id).orElseThrow(() -> new ProductNotFoundException(id));
	}
	


	@PostMapping("/products")
	public void addProduct(@RequestBody ProductDto productDto) {
		productService.addProduct(productDto);
		
	}
	
	@PutMapping("/products/{pId}")
	public void updateProduct(@RequestBody ProductDto productDto,
			@PathVariable("pId") int id) {
		productService.updateProduct(id, productDto);
		
	}

	@DeleteMapping("/products/{pId}")
	public void deleteProduct(@PathVariable("pId") int id) {
		
		productService.deleteProduct(id);
	}


}
