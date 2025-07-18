package com.synergystudy.synergystudy.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergystudy.synergystudy.data.models.Notification;
import com.synergystudy.synergystudy.data.repositories.NotificationRepo;
import com.synergystudy.synergystudy.dtos.response.GetNotificationResponse;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepo notificationRepo;

    @Autowired
    private MailService mailService;

    public GetNotificationResponse notifyUser(String email, String message) {
        
        Notification notification = new Notification();
        notification.setMessage(message);
        notification.setRecipientEmail(email);
        notification.setCreatedAt(LocalDateTime.now());
        notificationRepo.save(notification);

        mailService.sendNotificationEmail(email, message);

        GetNotificationResponse response = new GetNotificationResponse();
        response.setEmail(email);
        response.setMessage("Notification sent to" + email);

        return response;
    }
}



