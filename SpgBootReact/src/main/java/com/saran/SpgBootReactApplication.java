package com.saran;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.saran.dao.ProductRepo;
import com.saran.model.Product;
import com.saran.service.ProductService;

@SpringBootApplication
public class SpgBootReactApplication implements CommandLineRunner{

	@Autowired
	private ProductRepo repo;
	public static void main(String[] args) {
		SpringApplication.run(SpgBootReactApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 this.repo.save(new Product("Laptop",1234));
		 this.repo.save(new Product("Bed",1111));
		 this.repo.save(new Product("Desktop",2222));
		 this.repo.save(new Product("Furniture",3333));
		 this.repo.save(new Product("Chairs",4444));
		 
		
	}

}
