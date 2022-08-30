package com.springboot.jwt.controller;

import com.springboot.jwt.entity.Project;
import com.springboot.jwt.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@PostMapping({"/createNewProject"})
	public Project createNewProject(@RequestBody Project project) {
		return projectService.createNewProject(project);
	}
}