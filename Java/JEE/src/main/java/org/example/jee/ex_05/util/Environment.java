package org.example.jee.ex_05.util;

import io.github.cdimascio.dotenv.Dotenv;

public class Environment
{
	private static final Dotenv dotenv = Dotenv.configure()
			.load();

	private Environment()
	{
	}

	public static String getEnv(String key)
	{
		return dotenv.get(key);
	}
}
