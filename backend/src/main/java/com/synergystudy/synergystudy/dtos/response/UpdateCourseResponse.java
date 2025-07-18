package com.synergystudy.synergystudy.dtos.response;

import com.synergystudy.synergystudy.data.models.Course;

import lombok.Data;

@Data
public class UpdateCourseResponse {

    private String message;
    private Course course;
    private Long id;

}
