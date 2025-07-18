package com.synergystudy.synergystudy.data.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synergystudy.synergystudy.data.models.Notification;

@Repository
public interface NotificationRepo extends JpaRepository<Notification, Long> {
        Optional<Notification> findById(Long id);
    }



