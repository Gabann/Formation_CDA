import exercices.Adn;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Exercice26Test
{
	private static Stream<Arguments> provideAdnSequences()
	{
		return Stream.of(
				Arguments.of("act", "gtc", 0),
				Arguments.of("acac", "acac", 1),
				Arguments.of("actgtagt", "ac", 2.0 / 8),
				Arguments.of("actgtagt", "tgt", 3.0 / 8),
				Arguments.of("actgactgaa", "actgactg", 8.0 / 10),

				//Checks for sequence repeating multiple times but with non-matching sequence in the middle
				Arguments.of("acatac", "ac", 4.0 / 6),

				//Checks for case insensitivity
				Arguments.of("ACaTaC", "ac", 4.0 / 6),

				//Checks for whitespaces removal
				Arguments.of("   actgactgaa  ", "actgactg", 8.0 / 10),
				Arguments.of(" actgactgaa", "actgactg   ", 8.0 / 10),
				Arguments.of("   act   ", "gtc", 0),
				Arguments.of("actga ctgaa", "actga", 5.0 / 10)
		);
	}

	@ParameterizedTest
	@MethodSource("provideAdnSequences")
	void testGetAdnProportionPercentage(String inputAdn, String adnSequence, double expected)
	{
		double actual = Adn.getAdnProportionPercentage(inputAdn, adnSequence);
		assertEquals(expected, actual, 0.00001, "Wrong proportion");
	}
}
