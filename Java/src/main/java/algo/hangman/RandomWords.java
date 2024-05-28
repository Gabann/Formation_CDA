package algo.hangman;

import java.util.Random;

public class RandomWords
{
	private static final Random random = new Random();
	static String[] words = {
			"Java", "Object", "Class", "Method", "Variable", "Package", "Interface", "Inheritance", "Polymorphism",
			"Abstraction", "Encapsulation", "Constructor", "Destructor", "Exception", "Try", "Catch", "Finally", "Throws",
			"Throw", "Checked", "Unchecked", "Error", "StackTrace", "Debugging", "Breakpoint", "Conditional", "Loop",
			"While", "For", "Enhanced", "Switch", "If", "Else", "Ternary", "Array", "ArrayList", "LinkedList", "HashMap",
			"HashSet", "LinkedHashMap", "TreeSet", "Iterator", "Declaration", "Initialization", "Assignment", "Comparison",
			"Concatenation"
	};

	private RandomWords()
	{
		throw new IllegalStateException("Utility class");
	}

	static String getRandomWord()
	{

		return words[random.nextInt(0, words.length - 1)];
	}
}
