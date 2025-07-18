package com.synergystudy.synergystudy.dtos.requests;

import lombok.Data;

@Data
public class GetNotifictaionRequest {

    private Long id;
    private String title;
    private String email;
    private String phoneNumber; 
    private String message;

}
