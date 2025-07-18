package com.synergystudy.synergystudy.dtos.requests;

import java.util.List;

import com.synergystudy.synergystudy.data.models.Course;

import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
public class AddNewInstructorRequest{

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
  
    private List<Course> course;
    private String password;
}
