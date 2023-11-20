do
{
	age = prompt("Quel est votre age? : ");
} while (age < 0 || age >= 120)

console.log(age >= 18 ? "majeur" : "mineur");