package com.synergystudy.synergystudy.dtos.requests;

import lombok.Data;

@Data
public class RegisterCourseRequest {

    private Long id;
    private String title;
    private String email;

}
