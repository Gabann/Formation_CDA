package com.example.mvc.ex_06.service;

import com.example.mvc.ex_06.model.Topic;
import com.example.mvc.ex_06.repository.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService
{
	private final TopicRepository repository;

	public TopicService(TopicRepository topicRepository)
	{
		this.repository = topicRepository;
	}

	public List<Topic> getAll()
	{
		return repository.findAll();
	}

	public Topic getById(Long id)
	{
		return repository.findById(id).orElse(null);
	}
}
