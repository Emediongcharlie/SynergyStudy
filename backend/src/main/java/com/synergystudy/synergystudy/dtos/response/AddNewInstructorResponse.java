package com.synergystudy.synergystudy.dtos.response;

import java.util.List;

import com.synergystudy.synergystudy.data.models.Course;

import lombok.Data;

@Data
public class AddNewInstructorResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Course> course;
    private String password;
    private String message;
}
