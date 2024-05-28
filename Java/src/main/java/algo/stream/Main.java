package algo.stream;

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

//		Trouvez toutes les transactions en 2011 et les trier par valeur(petite à élevée) stocker ces données dans une liste de transactions.
		transactions.stream()
				.filter(transaction -> transaction.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue))
				.toList()
				.forEach(System.out::println);

		//Quelles sont toutes les villes uniques où les traders travaillent :stocker ses données dans une liste de villes (chaîne de caractères).2 possibilités (dont une en utilisant les Set).
		transactions.stream()
				.map(transaction -> transaction.getTrader().getCity())
				.collect(Collectors.toSet())
				.forEach(System.out::println);

		//En vous basant, toujours uniquement sur les transactions, renvoyez
		//une chaîne de noms de tous les traders triés par ordre
		//alphabétique
		transactions.stream()
				.map(transaction -> transaction.getTrader().getName())
				.collect(Collectors.toSet())
				.forEach(System.out::println);

		// Y a-t-il des commerçants basés à Milan ? On récupère un booléen
		//dans les résultats.
		System.out.println(transactions.stream()
				.anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan")));

		// Quelle est la valeur la plus élevée de toutes les transactions ? (On
		//récupère un optional d’entier).
		System.out.println(transactions.stream()
				.max(Comparator.comparing(Transaction::getValue))
				.map(Transaction::getValue));

		//Trouvez tous les traders de Cambridge et les triez par nom. On
		//récupère une liste de traders.
		transactions.stream()
				.map(Transaction::getTrader)
				.filter(trader -> trader.getCity().equals("Cambridge"))
				.collect(Collectors.toSet())
				.forEach(System.out::println);

		//Trouvez toutes les valeurs des transactions des traders vivant à
		//Cambridge : On récupère une liste d’entiers.
		transactions.stream()
				.filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
				.map(Transaction::getValue)
				.collect(Collectors.toSet())
				.forEach(System.out::println);

		//Recherchez la transaction avec la plus petite valeur
		System.out.println(transactions.stream()
				.min(Comparator.comparing(Transaction::getValue))
		);
	}
}
