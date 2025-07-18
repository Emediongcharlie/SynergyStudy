package com.synergystudy.synergystudy.dtos.requests;

import com.synergystudy.synergystudy.data.models.Course;

import lombok.Data;

@Data
public class DeleteCourseRequest {

    private Long id;
    private Course course;

}
