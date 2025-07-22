package com.synergystudy.synergystudy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendCourseRegistrationEmail(String toEmail, String courseTitle) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Course Registration Confirmation");
        message.setText("You have successfully registered for the course: " + courseTitle);
        message.setFrom("your_email@gmail.com");
        mailSender.send(message);
    }

    public void sendRegistrationEmail(String toEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Registration Confirmation");
        message.setText("You have been successfully registered");
        message.setFrom("your_email@gmail.com");
        mailSender.send(message);
    }

    public void sendNotificationEmail(String toEmail, String messageContent) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("New Notification");
        message.setText(messageContent);
        message.setFrom("your_email@gmail.com");
        mailSender.send(message);
    }
}
