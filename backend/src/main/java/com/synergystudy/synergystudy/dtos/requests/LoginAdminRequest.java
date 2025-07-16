package com.synergystudy.synergystudy.dtos.requests;

import lombok.Data;

@Data
public class LoginAdminRequest {

    private String email;
    private String password;

}
