let current = 40000, taux = 2, target = 80000;
let count = 0;

while (current <=  target){
	current *= 1 + taux / 100;
	
	count++;
}

console.log(count)