package com.example.mvc.ex_06.repository;

import com.example.mvc.ex_06.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long>
{
}
