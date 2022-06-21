package com.sms.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.com.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
