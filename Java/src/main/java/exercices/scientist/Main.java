package exercices.scientist;

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
				"John", // firstName
				"Doe", // lastName
				"1234567890", // phoneNumber
				"john.doe@example.com", // email
				"Some Company", // companyName
				"1 Some St, Some City, Some State", // companyAddress
				"0987654321" // professionalPhoneNumber
		);

		System.out.println(worker);
	}
}
