package tdd;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CitySearch
{
	static List<String> cityList =
			Arrays.asList("Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver", "Amsterdam", "Vienne", "Sydney", "New York",
					"Londres", "Bangkok", "Hong Kong", "Dubaï", "Rome", "Istanbul");

	private CitySearch()
	{
	}

	static List<String> searchCity(String query)
	{
		return Collections.emptyList();
	}

	public static class NotFoundException extends RuntimeException
	{

	}
}
