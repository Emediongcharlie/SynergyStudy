package com.synergystudy.synergystudy.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synergystudy.synergystudy.data.models.Admin;

public interface AdminRepo extends JpaRepository<Admin, Long> {

}
