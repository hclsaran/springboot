package com.saran.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saran.model.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>{

}
