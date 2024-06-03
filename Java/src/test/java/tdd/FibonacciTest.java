package tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest
{
	private static List<Integer> results;

	@BeforeAll
	static void setUp()
	{
		results = Fibonacci.getFibSeries(30);
	}

	@Test
	void testNotNull()
	{
		assertNotNull(results);
	}

	@Test
	void testRange6()
	{
		assertEquals(List.of(0, 1, 1, 2, 3, 5), Fibonacci.getFibSeries(6));
	}

	@Test
	void testContains3()
	{
		assertTrue(results.contains(3));
	}

	@Test
	void testNotContains4()
	{
		assertFalse(results.contains(4));
	}

	@Test
	void testSizeEqualRange()
	{
		assertEquals(6, Fibonacci.getFibSeries(6).size());
		assertEquals(15, Fibonacci.getFibSeries(15).size());
	}

	@Test
	void testResultsSorted()
	{
		assertEquals(results.stream().sorted().toList(), results);
	}
}
