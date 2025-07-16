package com.synergystudy.synergystudy.dtos.requests;

import lombok.Data;

@Data
public class AddNewAdminRequest {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}
