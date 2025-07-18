package com.synergystudy.synergystudy.dtos.requests;

import lombok.Data;

@Data
public class AddNewStudentRequest{

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String course;
    private String password;

}
