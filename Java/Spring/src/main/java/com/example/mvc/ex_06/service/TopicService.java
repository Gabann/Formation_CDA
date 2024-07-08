package com.example.mvc.ex_06.service;

import com.example.mvc.ex_06.model.Topic;
import com.example.mvc.ex_06.repository.TopicRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TopicService
{
	private final TopicRepository repository;
	private final UserService userService;

	public TopicService(TopicRepository topicRepository, UserService userService)
	{
		this.repository = topicRepository;
		this.userService = userService;

		repository.save(new Topic(userService.getById(1L), LocalDate.now(), LocalDate.now(), "Title"));
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
