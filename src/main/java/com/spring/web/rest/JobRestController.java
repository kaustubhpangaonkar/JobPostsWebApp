package com.spring.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.web.rest.entites.JobPost;
import com.spring.web.rest.services.JobService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

	@Autowired
	private JobService service;

	@GetMapping(path = "jobPosts")
//	@ResponseBody               this is only use when it is controller 
	public List<JobPost> getAllJobs() {

		return service.getAllPost();
	}

	@GetMapping("jobPost/{postId}")
	public JobPost getJob(@PathVariable("postId") int postId) {
		return service.getJob(postId);
	}

	@PostMapping(path = "jobPost")
	public JobPost addJob(@RequestBody JobPost post) {
		service.addJob(post);
		return post;
	}

	@PutMapping("jobPost")
	public JobPost updateJob(@RequestBody JobPost post) {
		service.updateJob(post);
		return service.getJob(post.getPostID());
	}

	@DeleteMapping("jobPost/{postId}")
	public String deletePost(@PathVariable int postId) {
		service.deletePost(postId);
		return "deleted";
	}

	@GetMapping("load")
	public String loadData() {

		service.load();

		return "Data load";
	}

	@GetMapping("jobPosts/keyword/{keyword}")
	public List<JobPost> findByKeyword(@PathVariable("keyword") String keyword) {
		return service.findByKeyword(keyword);
	}
}
