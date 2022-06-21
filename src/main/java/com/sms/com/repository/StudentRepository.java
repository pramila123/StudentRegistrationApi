package com.sms.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.com.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
