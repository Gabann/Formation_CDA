package tdd;

import java.util.Arrays;
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
		if (query.equals("*"))
		{
			return cityList;
		}

		if (query.length() < 2)
		{
			throw new NotFoundException();
		}

		return cityList.stream()
				.filter(s -> s.toLowerCase().contains(query.toLowerCase()))
				.toList();
	}

	public static class NotFoundException extends RuntimeException
	{

	}
}
