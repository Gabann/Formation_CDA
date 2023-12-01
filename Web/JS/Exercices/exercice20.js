module.exports = {verifyInput, getProportion};

//Checks if string only contains a, c, t or g
function verifyInput(str){
	str = lowercaseAndRemoveWhitespaces(str);
	
	for (let i = 0; i < str.length; i++) {
		let char = str.charAt(i);
		if (char !== "a" && char !== "t" && char !== "c" && char !== "g"){
			return false;
		}
	}
	return true;
}

//Returns the proportion of adn sequence inside the adn chain
function getProportion(adnChain, adnSequence){

	adnChain = lowercaseAndRemoveWhitespaces(adnChain);
	adnSequence = lowercaseAndRemoveWhitespaces(adnSequence);
	
	if (!adnChain.includes(adnSequence)){
		return 0;
	}

	let percentage= 0;

	for (let i = 0; i < adnChain.length;) {
		//Cut the adn chain to the adn sequence length and check if they are the same
		let str = adnChain.substring(i,  i + adnSequence.length);
		
		if (str === adnSequence){
			percentage += adnSequence.length / adnChain.length;
			
			i += adnSequence.length;
		}
		else i++;
	}
	
	return percentage;
}

function inputAdn(adnChain, adnSequence){
	// let adnChain = prompt("enter the adn chain");
	// let adnSequence = prompt("enter the adn sequence");

	if (!verifyInput(adnChain) || !verifyInput(adnSequence) || adnChain.length < adnSequence.length) return "Input error";
	
	let result= getProportion(adnChain, adnSequence);

	return `There is ${result * 100}% of ${adnSequence} in ${adnChain}`;
}

//Lowercase for case insensitivity and whitespace removal
function lowercaseAndRemoveWhitespaces(str){
	str = str.toLowerCase();
	str = str.replaceAll(' ', '');
	
	return str;
}

console.log(inputAdn("actgactgaa", "actgactg"));

