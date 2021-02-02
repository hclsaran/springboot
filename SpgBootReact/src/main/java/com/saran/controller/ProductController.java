package com.saran.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saran.model.Product;
import com.saran.service.ProductService;
@CrossOrigin(origins="http://localhost:3000")
@RestController
public class ProductController {
	@Autowired
	 private ProductService service;
	    @GetMapping("/")
	   public List<Product> getAllProducts(){
		   return service.getAllProducts();
	   }
	   

}
