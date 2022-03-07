package com.ttb.fleet.notification.repository;

import com.ttb.fleet.notification.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    Message findByMessageIdAndLanguage(Integer messageId,String language);
}

