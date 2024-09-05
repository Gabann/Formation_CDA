package tdd;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CitySearchTest
{
	@Test
	void testInputSizeTooShort()
	{
		assertThrows(CitySearch.NotFoundException.class, () -> CitySearch.searchCity("s"));
		assertThrows(CitySearch.NotFoundException.class, () -> CitySearch.searchCity(""));
		assertThrows(CitySearch.NotFoundException.class, () -> CitySearch.searchCity("A"));
	}

	@Test
	void testInputStartsWithVa()
	{
		assertEquals(List.of("Valence", "Vancouver"), CitySearch.searchCity("Va"));
	}

	@Test
	void testCaseNonSensitive()
	{
		assertEquals(List.of("Sydney"), CitySearch.searchCity("Sy"));
		assertEquals(List.of("Sydney"), CitySearch.searchCity("SY"));
		assertEquals(List.of("Sydney"), CitySearch.searchCity("sy"));
	}

	@Test
	void testQueryFoundInMiddle()
	{
		assertEquals(List.of("Budapest"), CitySearch.searchCity("ape"));
	}

	@Test
	void testReturnAllCities()
	{
		assertEquals(CitySearch.cityList, CitySearch.searchCity("*"));
	}
}
