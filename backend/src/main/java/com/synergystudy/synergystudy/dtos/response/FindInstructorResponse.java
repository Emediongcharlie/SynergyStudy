package com.synergystudy.synergystudy.dtos.response;

import lombok.Data;

@Data
public class FindInstructorResponse {

    private Long id;
    private String message;
    private String firstName;
    private String lastName;
    private String email;

}
