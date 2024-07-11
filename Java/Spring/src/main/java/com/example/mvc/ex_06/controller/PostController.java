package com.example.mvc.ex_06.controller;

import com.example.mvc.ex_06.model.Post;
import com.example.mvc.ex_06.service.PostService;
import com.example.mvc.ex_06.service.TopicService;
import com.example.mvc.ex_06.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("forum/post")
public class PostController
{
	PostService postService;
	TopicService topicService;
	UserService userService;

	public PostController(PostService postService, TopicService topicService, UserService userService)
	{
		this.postService = postService;
		this.topicService = topicService;
		this.userService = userService;
	}

	@PostMapping("forum/post/add")
	String postPost(@ModelAttribute Post post)
	{
		System.out.println(post);
		postService.save(post);
		return "redirect:/forum/topic/1";
	}

	@GetMapping("forum/post/add")
	String addPost(@RequestParam Long topicId, Model model)
	{
		model.addAttribute("post",
				new Post.Builder()
						.topic(topicService.getById(topicId))
						.postingDate(LocalDate.now())
						.author(userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName()))
						.build());
		return "ex_06/secured/addPost";
	}
}
