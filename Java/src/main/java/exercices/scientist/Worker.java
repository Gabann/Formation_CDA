package exercices.scientist;

public class Worker extends Person
{
	String companyName;
	String companyAddress;
	String professionalPhoneNumber;

	public Worker(String firstName, String lastName, String phoneNumber, String email, String companyName, String companyAddress, String professionalPhoneNumber)
	{
		super(firstName, lastName, phoneNumber, email);
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.professionalPhoneNumber = professionalPhoneNumber;
	}

	@Override
	public String toString()
	{
		return super.toString() + "\n" +
				"Worker{" + "companyName='" + companyName +
				'\'' + ", companyAddress='" + companyAddress +
				'\'' + ", professionalPhoneNumber='" + professionalPhoneNumber +
				'\'' + "} ";
	}
}
