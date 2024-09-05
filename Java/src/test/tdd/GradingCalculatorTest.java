package test.tdd;

import org.junit.jupiter.api.Test;
import tdd.GradingCalculator;

class GradingCalculatorTest
{
	@Test
	void testScore95Attendance90()
	{
		GradingCalculator gradingCalculator = new GradingCalculator(95, 90);
		assertEquals('A', gradingCalculator.getGrade());
	}

	@Test
	void testScore85Attendance90()
	{
		GradingCalculator gradingCalculator = new GradingCalculator(85, 90);
		assertEquals('B', gradingCalculator.getGrade());
	}

	@Test
	void testScore65Attendance90()
	{
		GradingCalculator gradingCalculator = new GradingCalculator(65, 90);
		assertEquals('C', gradingCalculator.getGrade());
	}

	@Test
	void testScore95Attendance65()
	{
		GradingCalculator gradingCalculator = new GradingCalculator(95, 65);
		assertEquals('B', gradingCalculator.getGrade());
	}

	@Test
	void testScore95Attendance55()
	{
		GradingCalculator gradingCalculator = new GradingCalculator(95, 55);
		assertEquals('F', gradingCalculator.getGrade());
	}

	@Test
	void testScore65Attendance55()
	{
		GradingCalculator gradingCalculator = new GradingCalculator(65, 55);
		assertEquals('F', gradingCalculator.getGrade());
	}

	@Test
	void testScore50Attendance90()
	{
		GradingCalculator gradingCalculator = new GradingCalculator(50, 90);
		assertEquals('F', gradingCalculator.getGrade());
	}
}
