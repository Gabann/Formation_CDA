let inputNumber = 100, divider = 2;
let primeNumbers = [];

function isPrime(number){
	// 2 Is the only even prime number, we have to make an extra check for it
	if (number === 2 ){
		return true;
	}
	//Numbers below 1 are not prime
	if (number <= 1 || number % 2 === 0){
		return false;
	}
	
	//If we find a divider the number is not prime, dividers greater than half the number will never be prime
	for (let i = 3; i <= number / 2; i+= 2){
		if (number % i === 0){
			return false;
		}
	}
	
	return true;
}

while (divider <= inputNumber){
	if (isPrime(divider)){
		primeNumbers.push(divider);
	}
	
	divider += divider % 2 === 0 ? 1 : 2;
}

console.log(primeNumbers);