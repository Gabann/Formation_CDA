let inputNumber = Number(prompt("Nombre lignes"));

for (let i = 0; i < inputNumber; i++) {
	console.log(`${" ".repeat(inputNumber - i)} ${"*".repeat(1 + 2 * i)}`);
}