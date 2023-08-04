package com.skillsoft.springboot.exception;

public class ProductNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ProductNotFoundException(int id) {
		super("The product with " + id + "cannot be found!");
	}
	 
}
