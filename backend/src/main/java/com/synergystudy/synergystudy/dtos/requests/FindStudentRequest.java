package com.synergystudy.synergystudy.dtos.requests;

import lombok.Data;

@Data
public class FindStudentRequest {

    private Long id;
    private String email;

}
