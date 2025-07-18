package com.synergystudy.synergystudy.dtos.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class RegisterCourseResponse {

    private Long id;
    private String title;
    private String message;
    private LocalDateTime registeredAt;

}
