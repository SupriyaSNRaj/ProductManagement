package com.skillsoft.springboot.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillsoft.springboot.dto.ProductDto;
import com.skillsoft.springboot.model.Product;
import com.skillsoft.springboot.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
    public List<ProductDto> getAllProducts(){
		
		List<Product> products = new ArrayList<>();
		
		productRepository.findAll().forEach(products::add);
		List<ProductDto> productsDto = new ArrayList<>();
		for (Iterator iterator = products.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			
			ProductDto pro = new ProductDto();
			pro.setId(product.getId());
			pro.setName(product.getName());
			pro.setCategory(product.getCategory());
			productsDto.add(pro);
			
		}
		return productsDto;
	}
	
	public Optional<Product> getProduct(int id){
  
		return productRepository.findById(id);
	}
	
	public void addProduct(ProductDto productDto) {
		Product product = new Product();
		String name = productDto.getName();
		String category = productDto.getCategory();
		product.setName(name);
		product.setCategory(category);
		  
		productRepository.save(product);
	}
	
	public void updateProduct(int id, ProductDto productDto) {
		
		Product product = new Product();
		String name = productDto.getName();
		String category = productDto.getCategory();
		
		product.setName(name);
		product.setCategory(category);
		product.setId(id);
          
		if(productRepository.findById(id).get() != null) {
			productRepository.save(product);
		}
	}

	public void deleteProduct(int id) {
      
		productRepository.deleteById(id);
	}
	

}


