function printHead(spaceBetween) {
	let separator = "";
	let line = "";

	for (let i = 1; i < 11; i++) {
		separator += `${"==".repeat(spaceBetween)}`;
		// line += `| ${i} `;
		line += `|${(i).toString().padStart(spaceBetween, " ")} `;
	}

	console.log(separator);
	console.log(line);
	console.log(separator);
}

function printBody(input, spaceBetween) {
	let separator = "";
	for (let i = 0; i < 10; i++) {
		separator += `+${"-".repeat(spaceBetween + 1)}`;
	}

	for (let i = 1; i < input + 1; i++) {
		line = "";

		for (let j = 1; j < 11; j++) {
			line += `|${(i * j).toString().padStart(spaceBetween, " ")} `;
		}

		console.log(line);
		console.log(separator);
	}
}

let inputNumber;
let spaceBetween;

do {
	inputNumber = Number(prompt("Entrez le nombre de tables"));
}
while (inputNumber < 1 || isNaN(inputNumber));

do {
	spaceBetween = Number(prompt("Entrez l'espace entre les tables (entre 3 et 8)"));
}
while ((spaceBetween < 3 || spaceBetween > 8) || isNaN(spaceBetween));

printHead(spaceBetween);
printBody(inputNumber, spaceBetween);