package com.example.ex_06.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "post")
public class Post
{
	@Column(columnDefinition = "TEXT")
	String content;
	LocalDate postingDate;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "author_id")
	private User author;

	@OneToOne(orphanRemoval = true)
	@JoinColumn(name = "topic_id")
	private Topic topic;

	public Post()
	{
	}

	public Post(Builder builder)
	{
		setContent(builder.content);
		setPostingDate(builder.postingDate);
		setId(builder.id);
		setAuthor(builder.author);
		setTopic(builder.topic);
	}

	public static final class Builder
	{
		private String content;
		private LocalDate postingDate;
		private Long id;
		private User author;
		private Topic topic;

		public Builder()
		{
		}

		public Builder content(String val)
		{
			content = val;
			return this;
		}

		public Builder postingDate(LocalDate val)
		{
			postingDate = val;
			return this;
		}

		public Builder id(Long val)
		{
			id = val;
			return this;
		}

		public Builder author(User val)
		{
			author = val;
			return this;
		}

		public Builder topic(Topic val)
		{
			topic = val;
			return this;
		}

		public Post build()
		{
			return new Post(this);
		}
	}
}
