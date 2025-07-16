package com.synergystudy.synergystudy.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synergystudy.synergystudy.data.models.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

}
