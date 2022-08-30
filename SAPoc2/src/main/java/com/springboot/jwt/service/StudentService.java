package com.springboot.jwt.service;

import com.springboot.jwt.dao.ProjectDao;
import com.springboot.jwt.dao.StudentDao;
import com.springboot.jwt.entity.Project;
import com.springboot.jwt.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private ProjectDao projectDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public void initRoleAndUser() {

		Project adminRole = new Project();
		adminRole.setRoleName("Admin");
		adminRole.setProjectId("111");
		adminRole.setProjectName("Student Application");
		adminRole.setProjectDescription("application based on java programming");

		projectDao.save(adminRole);

		Project userRole = new Project();
		userRole.setRoleName("Student");
		userRole.setProjectId("222");
		userRole.setProjectName("User application");
		userRole.setProjectDescription("application based on jaca programming");
		projectDao.save(userRole);

		Student adminUser = new Student();
		adminUser.setUserName("pooja123");
		adminUser.setUserPassword(getEncodedPassword("pooja@pass"));
		adminUser.setStudentFirstName("pooja");
		adminUser.setStudentLastName("patil");
		adminUser.setEmailId("pooja@gmail.com");
		adminUser.setMobNo("12345679");
		Set<Project> adminRoles = new HashSet<>();
		adminRoles.add(adminRole);
		adminUser.setProject(adminRoles);
		studentDao.save(adminUser);

	}

	public Student registerNewStudent(Student user) {
		Project role = projectDao.findById("User").get();
		Set<Project> userRoles = new HashSet<>();
		userRoles.add(role);
		user.setProject(userRoles);
		user.setUserPassword(getEncodedPassword(user.getUserPassword()));

		return studentDao.save(user);
	}

	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}

	public List<Student> getAllStudents() {
		List<Student> studentList= this.studentDao.findAll();
		return studentList;
	}

	public Student getStudent(String studentId) {
		Student foundStudent=this.studentDao.findById(studentId).orElse(null);
		return foundStudent;
	}
}