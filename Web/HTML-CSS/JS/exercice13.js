let target = 135;
let results = ""

for (let i = 1; i < target / 2 + 1; i++) {
	let total = 0;
	let calcul = ""
	
	for (let j = i; j < target / 2 + 1; j++) {
		total += j;
		calcul += j + "-";
		
		if (total > target) break;
		else if (total === target){
			results += `${calcul} \n`;
		}
	}
}

console.log(results);