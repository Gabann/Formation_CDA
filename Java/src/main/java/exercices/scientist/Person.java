package exercices.scientist;

public abstract class Person
{
	String firstName;
	String lastName;
	String phoneNumber;
	String email;

	protected Person(String firstName, String lastName, String phoneNumber, String email)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	@Override
	public String toString()
	{
		return "Person{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
