package com.synergystudy.synergystudy.dtos.requests;

import com.synergystudy.synergystudy.data.models.Course;

import lombok.Data;

@Data
public class UpdateCourseRequest {

    private Course course;

}
