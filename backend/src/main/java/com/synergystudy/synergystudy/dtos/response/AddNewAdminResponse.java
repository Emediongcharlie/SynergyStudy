package com.synergystudy.synergystudy.dtos.response;

import lombok.Data;

@Data
public class AddNewAdminResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String message;
    private String password;

}
