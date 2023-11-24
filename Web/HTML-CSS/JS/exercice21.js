let array = [];
array.length = 10;

for (let i = 0; i < array.length; i++) {
	array[i] = Math.floor(Math.random() * 100);
}

for (let i = 0; i < array.length; i++) {
	console.log(`${"    ".repeat(i)}${array[i]}`);
}