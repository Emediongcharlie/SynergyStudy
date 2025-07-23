package com.synergystudy.synergystudy.dtos.response;

import com.synergystudy.synergystudy.data.models.Course;

import lombok.Data;

@Data
public class DeleteCourseResponse {

    private Course course;
    private Long id;
    private String message;

}
