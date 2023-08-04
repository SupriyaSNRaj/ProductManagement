package com.skillsoft.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.skillsoft.springboot.model.Product;
import com.skillsoft.springboot.repository.ProductRepository;

@SpringBootApplication
public class SpringRestApplication implements CommandLineRunner  {
	
	@Autowired
	private ProductRepository productRepository;


	public static void main(String[] args) {
		SpringApplication.run(SpringRestApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		
		
//		productRepository.save(new Product("Television", "Electronics"));
//		productRepository.save(new Product("Air Conditioner", "Electronics"));
//		productRepository.save(new Product("Sofa", "Furniture"));
//		productRepository.save(new Product("Cushions", "Home Essentials"));
//		productRepository.save(new Product("Wardrobe", "Furniture"));
//		
		
		
	}

}
