package tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FibonaciTest
{
	@Test
	void testRange1()
	{
		List<Integer> results = Fibonaci.getFibSeries(1);

		Assertions.assertNotNull(results);
		assertEquals(List.of(0), results);
	}

	@Test
	void testRange6()
	{
		List<Integer> results = Fibonaci.getFibSeries(6);

		assertTrue(results.contains(3));
		assertEquals(6, results.size());
		assertFalse(results.contains(4));
		assertEquals(results.stream().sorted().toList(), results);

		Assertions.assertNotNull(results);
		assertEquals(List.of(0, 1, 1, 2, 3, 5), results);
	}
}
