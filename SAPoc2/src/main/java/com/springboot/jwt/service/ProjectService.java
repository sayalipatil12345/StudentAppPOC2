package com.springboot.jwt.service;


import com.springboot.jwt.dao.ProjectDao;
import com.springboot.jwt.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

	@Autowired
	private ProjectDao projectDao;

	public Project createNewProject(Project project) {
		return projectDao.save(project);
	}
}
