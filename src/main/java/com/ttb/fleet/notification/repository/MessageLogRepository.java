package com.ttb.fleet.notification.repository;

import com.ttb.fleet.notification.entity.MessageLog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MessageLogRepository extends JpaRepository<MessageLog, Integer> {
        
}
