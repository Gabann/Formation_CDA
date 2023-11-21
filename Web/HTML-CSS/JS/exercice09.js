let inputNumber;

do {
	inputNumber = Number(prompt("entrez n"));
}
while (inputNumber < 1 || isNaN(inputNumber))

for (let i = 1; i < inputNumber + 1; i++) {

	for (let j = 1; j < 11; j++) {
		console.log(`${i} x ${j} = ${i * j}`)
	}
}