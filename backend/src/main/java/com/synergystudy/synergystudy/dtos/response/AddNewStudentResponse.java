package com.synergystudy.synergystudy.dtos.response;

import lombok.Data;

@Data
public class AddNewStudentResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String course;
    private String password;

}
