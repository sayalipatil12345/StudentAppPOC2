package com.springboot.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.jwt.entity.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, String> {

}