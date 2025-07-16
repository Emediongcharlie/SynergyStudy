package com.synergystudy.synergystudy.data.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synergystudy.synergystudy.data.models.Instructor;

public interface InstructorRepo extends JpaRepository<Instructor, Long> {

    Optional<Instructor> findByEmail(String email);
}
