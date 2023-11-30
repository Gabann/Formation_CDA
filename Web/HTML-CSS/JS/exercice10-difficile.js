function getRandomColoredChar() {
	const chars = ["O", "*"];

	return getRandomColor() + chars[Math.floor(Math.random() * chars.length)];
}

function getRandomColor() {
	const colors = ["\u001b[31m", "\u001b[32m", "\u001b[33m", "\u001b[34m"];

	return colors[Math.floor(Math.random() * colors.length)];
}

//Prends les inputs
do {
	inputNumber = Number(prompt("Entrez le nombre de lignes"));
}
while (inputNumber < 1 || isNaN(inputNumber));

do {
	legLength = Number(prompt("Entrez la taille des jambes"));
}
while (legLength < 1 || isNaN(legLength));

console.log(`${" ".repeat(inputNumber)}${getRandomColor()}A`);

//Affiche le corps du sapin
for (let i = 1; i < inputNumber; i++) {

	let str = `${" ".repeat(inputNumber - i)}`;

	for (let j = 0; j < 1 + 2 * i; j++) {
		str += getRandomColoredChar();
	}

	console.log(str);
}

//Affiche les pieds du sapin
console.log(`${" ".repeat(inputNumber - 2)} | | \n`.repeat(legLength - 1));
console.log(`${" ".repeat(inputNumber - 5)}_ _ |_| _ _\n`);