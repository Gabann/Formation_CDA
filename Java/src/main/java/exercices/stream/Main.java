package exercices.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main
{
	public static void main(String[] args)
	{
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 400),
				new Transaction(brian, 2012, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 410),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
		);

		transactions.stream()
				.filter(transaction -> transaction.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue))
				.toList()
				.forEach(System.out::println);

		transactions.stream()
				.map(transaction -> transaction.getTrader().getCity())
				.collect(Collectors.toSet())
				.forEach(System.out::println);

		transactions.stream()
				.map(transaction -> transaction.getTrader().getName())
				.collect(Collectors.toSet())
				.forEach(System.out::println);

		System.out.println(transactions.stream()
				.anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan")));

		System.out.println(transactions.stream()
				.max(Comparator.comparing(Transaction::getValue))
				.map(Transaction::getValue));

		transactions.stream()
				.map(Transaction::getTrader)
				.filter(trader -> trader.getCity().equals("Cambridge"))
				.collect(Collectors.toSet())
				.forEach(System.out::println);

		transactions.stream()
				.filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
				.map(Transaction::getValue)
				.collect(Collectors.toSet())
				.forEach(System.out::println);

		System.out.println(transactions.stream()
				.min(Comparator.comparing(Transaction::getValue))
		);
	}
}
