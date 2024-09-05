package algo;

import algo.procedural.Adn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("SpellCheckingInspection")
class AdnTest
{
	private static Stream<Arguments> testBase()
	{
		return Stream.of(
				Arguments.of("act", "gtc", 0),
				Arguments.of("acac", "acac", 1),
				Arguments.of("actgtagt", "ac", 2.0 / 8),
				Arguments.of("actgtagt", "tgt", 3.0 / 8),
				Arguments.of("actgactgaa", "actgactg", 8.0 / 10)
		);
	}

	private static Stream<Arguments> testSequenceRepeatingWithBreak()
	{
		return Stream.of(
				Arguments.of("acatac", "ac", 4.0 / 6)
		);
	}

	private static Stream<Arguments> testCaseInsensitivity()
	{
		return Stream.of(
				Arguments.of("ACaTaC", "ac", 4.0 / 6)
		);
	}

	private static Stream<Arguments> testWhiteSpaceRemoval()
	{
		return Stream.of(
				Arguments.of("act", "gtc", 0),
				Arguments.of("acac", "acac", 1),
				Arguments.of("actgtagt", "ac", 2.0 / 8),
				Arguments.of("actgtagt", "tgt", 3.0 / 8),
				Arguments.of("actgactgaa", "actgactg", 8.0 / 10)
		);
	}

	@ParameterizedTest
	@MethodSource("testBase")
	void testGetAdnProportionPercentage(String inputAdn, String adnSequence, double expected)
	{
		Test(inputAdn, adnSequence, expected);
	}

	public void Test(String inputAdn, String adnSequence, double expected)
	{
		double actual = Adn.getAdnProportionPercentage(inputAdn, adnSequence);
		assertEquals(expected, actual, 0.00001, "Wrong proportion");
	}

	@ParameterizedTest
	@MethodSource("testSequenceRepeatingWithBreak")
	@DisplayName("Test Sequence Repeating With Break")
	void testSequenceRepeatingWithBreak(String inputAdn, String adnSequence, double expected)
	{
		Test(inputAdn, adnSequence, expected);
	}

	@ParameterizedTest
	@MethodSource("testCaseInsensitivity")
	@DisplayName("Test Case Insensitivity")
	void testCaseInsensitivity(String inputAdn, String adnSequence, double expected)
	{
		Test(inputAdn, adnSequence, expected);
	}

	@ParameterizedTest
	@MethodSource("testWhiteSpaceRemoval")
	@DisplayName("Test White Space Removal")
	void testWhiteSpaceRemoval(String inputAdn, String adnSequence, double expected)
	{
		Test(inputAdn, adnSequence, expected);
	}
}
