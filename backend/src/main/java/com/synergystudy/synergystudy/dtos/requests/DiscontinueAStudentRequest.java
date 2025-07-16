package com.synergystudy.synergystudy.dtos.requests;

import com.synergystudy.synergystudy.data.models.Course;
import com.synergystudy.synergystudy.data.models.Student;

import lombok.Data;

@Data
public class DiscontinueAStudentRequest {

    private Student courStudent;
    private Course course;

}
