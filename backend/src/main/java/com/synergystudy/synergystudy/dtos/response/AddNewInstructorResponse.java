package com.synergystudy.synergystudy.dtos.response;

import com.synergystudy.synergystudy.data.models.Course;

import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
public class AddNewInstructorResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    @ManyToMany
    private Course course;
    private String password;
    private String message;
}
