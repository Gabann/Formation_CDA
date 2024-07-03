package com.example.ex_06.repository;

import com.example.ex_06.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>
{
	List<Post> findByTopicId(Long id);
}
