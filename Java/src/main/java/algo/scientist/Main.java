package algo.scientist;

import java.util.List;

public class Main
{
	public static void main(String[] args)
	{
		Scientist scientist = new Scientist(
				"Albert",
				"Einstein",
				"1234567890",
				"albert.einstein@example.com",
				"Princeton University",
				"1 Nassau St, Princeton, NJ 08542",
				"0987654321",
				List.of("Theoretical Physicist", "Test"),
				List.of("Physics", "Mathematics")
		);

		System.out.println(scientist);

		Worker worker = new Worker(
				"John",
				"Doe",
				"1234567890",
				"john.doe@example.com",
				"Some Company",
				"1 Some St, Some City, Some State",
				"0987654321"
		);

		System.out.println(worker);
	}
}
