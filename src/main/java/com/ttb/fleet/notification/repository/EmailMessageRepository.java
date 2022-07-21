package com.ttb.fleet.notification.repository;

import com.ttb.fleet.notification.entity.EmailMessage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailMessageRepository extends JpaRepository<EmailMessage, String> {

}
