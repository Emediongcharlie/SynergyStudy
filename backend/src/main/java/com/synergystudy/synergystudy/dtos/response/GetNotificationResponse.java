package com.synergystudy.synergystudy.dtos.response;

import lombok.Data;

@Data
public class GetNotificationResponse {

    private String id;
    private String email;
    private String message;

}
