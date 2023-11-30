let temp = Number(prompt("Temperature : "));

if (temp >= 100) {
	console.log("gazeux");
} else if (temp >= 0) {
	console.log("liquide");
} else {
	console.log("solide");
}

// console.log(temp > 100 ? "gazeux" : temp >= 0 ? "liquide" : "solide");