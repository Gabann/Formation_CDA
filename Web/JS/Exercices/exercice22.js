// let input = prompt("How many numbers");
let input = 10;

let array = [];
array.length = input;

for (let i = 0; i < array.length; i++) {
	array[i] = Math.floor(Math.random() * 50);
}

for (let i = 0; i < array.length; i++) {
	let evenOrOddString = array[i] % 2 === 0 ? "pair" : "impair";
	console.log(`Le nombre ${array[i]} est ${evenOrOddString}`);
}