package com.spring.web.rest.entites;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // this is lombok annotation which reduce code for getter and setter
@AllArgsConstructor // this is lombok annotation which reduce code for paramterized constructor
@NoArgsConstructor // this is lombok annotation which reduce code for non paramterized constructor
@Component
@Entity
public class JobPost {
	@Id
	private int postID;

	private String postProfile;

	private String postDesc;

	private int reqExperience;

	private List<String> postTechStack;

}
