package com.springboot.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.jwt.entity.Project;

@Repository
public interface ProjectDao extends  JpaRepository<Project, String> {

}