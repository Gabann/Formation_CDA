package exercices.chair;

public class Main
{
	public static void main(String[] main)
	{
		Chair chair1 = new Chair();
		Chair chair2 = new Chair("Pink", 3, 40, "Metal");

		chair1.describeChair();
		chair2.describeChair();
	}
}
