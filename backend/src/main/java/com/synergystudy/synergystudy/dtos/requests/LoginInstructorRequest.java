package com.synergystudy.synergystudy.dtos.requests;

import lombok.Data;

@Data
public class LoginInstructorRequest {

    private String email;
    private String password;
}
