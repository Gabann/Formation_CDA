package exercices;

public class PrintFullName
{
	static String printFullName(String firstName, String lastName)
	{
		return firstName + " " + lastName;
	}

	public static void main(String[] args)
	{
		System.out.println(printFullName("John", "Doe"));
	}
}
