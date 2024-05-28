package algo.scientist;

import java.util.ArrayList;
import java.util.List;

public class Scientist extends Worker
{
	List<String> subject = new ArrayList<>();
	List<String> scientistType = new ArrayList<>();

	public Scientist(String firstName, String lastName, String phoneNumber, String email, String companyName, String companyAddress,
	                 String professionalPhoneNumber, List<String> scientistType, List<String> subject)
	{
		super(firstName, lastName, phoneNumber, email, companyName, companyAddress, professionalPhoneNumber);
		this.subject = subject;
		this.scientistType = scientistType;
	}

	@Override
	public String toString()
	{
		return super.toString() + "\n" +
				"Scientist{" + "subject='" + subject +
				'\'' + ", scientistType='" + scientistType +
				'\'' + "} ";
	}
}
