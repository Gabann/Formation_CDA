package com.example.ex_06.service;

import com.example.ex_06.model.Post;
import com.example.ex_06.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService
{
	private final PostRepository repository;

	public PostService(PostRepository postRepository)
	{
		this.repository = postRepository;
	}

	public List<Post> getByTopicId(Long topicId)
	{
		return repository.findByTopicId(topicId);
	}

	public void save(Post post)
	{
		repository.save(post);
	}
}
