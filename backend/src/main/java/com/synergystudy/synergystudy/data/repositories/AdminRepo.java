package com.synergystudy.synergystudy.data.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synergystudy.synergystudy.data.models.Admin;
import com.synergystudy.synergystudy.data.models.Instructor;

public interface AdminRepo extends JpaRepository<Admin, Long> {

    Optional<Admin> findByEmail(String email);
}
