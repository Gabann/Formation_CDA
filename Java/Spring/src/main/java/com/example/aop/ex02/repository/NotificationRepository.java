package com.example.aop.ex02.repository;

import com.example.aop.ex02.entity.Notification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Long>
{
}
