package com.saran.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saran.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

}