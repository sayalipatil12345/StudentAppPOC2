package com.springboot.jwt.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Project {
	
	@Id
	String roleName;
	String projectId;
	String projectName;
	String projectDescription;
	
	

}
