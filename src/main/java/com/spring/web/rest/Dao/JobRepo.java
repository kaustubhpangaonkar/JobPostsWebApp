package com.spring.web.rest.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.spring.web.rest.entites.JobPost;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

	List<JobPost> findByPostProfileContainingOrPostDescContaining(String PostProfile, String PostDesc);
}
