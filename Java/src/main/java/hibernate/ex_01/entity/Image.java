package hibernate.ex_01.entity;

import javax.persistence.*;

@Entity
public class Image
{
	String url;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	public Image()
	{
	}

	private Image(Builder builder)
	{
		url = builder.url;
	}


	public static final class Builder
	{
		private String url;

		public Builder()
		{
		}

		public Builder url(String val)
		{
			url = val;
			return this;
		}

		public Image build()
		{
			return new Image(this);
		}
	}
}
