package com.synergystudy.synergystudy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.synergystudy.synergystudy.data.models.Admin;
import com.synergystudy.synergystudy.data.models.Instructor;
import com.synergystudy.synergystudy.data.models.Student;
import com.synergystudy.synergystudy.data.repositories.AdminRepo;
import com.synergystudy.synergystudy.data.repositories.InstructorRepo;
import com.synergystudy.synergystudy.data.repositories.StudentRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    AdminRepo adminRepo;

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    InstructorRepo instructorRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Admin admin = adminRepo.findByEmail(email).orElse(null);
        if (admin != null) {
            return User.builder()
                    .username(admin.getEmail())
                    .password(admin.getPassword())
                    .roles("ADMIN")
                    .build();
        }

        Student student = studentRepo.findByEmail(email).orElse(null);
        if (student != null) {
            return User.builder()
                    .username(student.getEmail())
                    .password(student.getPassword())
                    .roles("STUDENT")
                    .build();
        }

        Instructor instructor = instructorRepo.findByEmail(email).orElse(null);
        if (instructor != null) {
            return User.builder()
                    .username(instructor.getEmail())
                    .password(instructor.getPassword())
                    .roles("INSTRUCTOR")
                    .build();
        }

        throw new UsernameNotFoundException("User not found with email: " + email);
    }

}
