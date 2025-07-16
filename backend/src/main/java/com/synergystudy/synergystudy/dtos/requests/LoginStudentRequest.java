package com.synergystudy.synergystudy.dtos.requests;

import lombok.Data;

@Data
public class LoginStudentRequest {

    private String email;
    private String password;
}
