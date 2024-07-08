package com.example.mvc.ex_06.controller;

import com.example.mvc.ex_06.model.Post;
import com.example.mvc.ex_06.service.PostService;
import com.example.mvc.ex_06.service.TopicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("forum/topic")
public class TopicController
{
	TopicService topicService;
	PostService postService;

	public TopicController(TopicService topicService, PostService postService)
	{
		this.topicService = topicService;
		this.postService = postService;
	}

	@GetMapping("all")
	String getAll(Model model)
	{
		model.addAttribute("topics", topicService.getAll());
		return "ex_06/secured/topicList";
	}

	@GetMapping("{id}")
	String getById(@PathVariable Long id, Model model)
	{
		List<Post> posts = postService.getByTopicId(id);

		model.addAttribute("topic", topicService.getById(id));
		model.addAttribute("posts", posts);
		return "ex_06/secured/topicDetails";
	}
}
