package com.synergystudy.synergystudy.data.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synergystudy.synergystudy.data.models.Course;



public interface CourseRepo extends JpaRepository<Course, Long>{

    Optional<Course> findById(Long id);
    Optional<Course> findByTitle(String title);


}
