package com.saran.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saran.dao.ProductRepo;
import com.saran.model.Product;

@Service
public class ProductService {
	@Autowired
	private ProductRepo repo;
	
	public List<Product> getAllProducts(){
		return repo.findAll();
	}

}
