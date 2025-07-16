package com.synergystudy.synergystudy.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synergystudy.synergystudy.data.models.Course;

public interface CourseRepo extends JpaRepository<Course, Long>{

}
