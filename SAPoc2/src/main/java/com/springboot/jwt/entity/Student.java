package com.springboot.jwt.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Student {

    @Id
    private String userName;
    private String studentFirstName;
    private String studentLastName;
    private String mobNo;
    private String emailId;
    private String userPassword;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "STUDENT_PROJECT",
            joinColumns = {
                    @JoinColumn(name = "STUDENT_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "PROJECT_ID")
            }
    )
    private Set<Project> project;
	
    
}