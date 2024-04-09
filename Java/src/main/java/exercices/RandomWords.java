package exercices;

import java.util.Random;

public class RandomWords
{
	static String[] words = {
			"Java", "Object", "Class", "Method", "Variable", "Package", "Interface", "Inheritance", "Polymorphism",
			"Abstraction", "Encapsulation", "Constructor", "Destructor", "Exception", "Try", "Catch", "Finally", "Throws",
			"Throw", "Checked", "Unchecked", "Error", "StackTrace", "Debugging", "Breakpoint", "Conditional", "Loop",
			"While", "For", "Enhanced", "Switch", "If", "Else", "Ternary", "Array", "ArrayList", "LinkedList", "HashMap",
			"HashSet", "LinkedHashMap", "TreeSet", "Iterator", "Declaration", "Initialization", "Assignment", "Comparison",
			"Concatenation"
	};

	static String getRandomWord()
	{
		Random rand = new Random();

		return words[rand.nextInt(0, words.length - 1)];
	}
}
