function countALetter(str){
	let count = 0;
	
	//Convert to lowercase for case insensitivity
	str = str.toLowerCase();
	
	for (let i = 0; i < str.length; i++) {
		if (str.charAt(i) === "a"){
			count++;
		}
	}
	
	return count;
}

console.log(countALetter("abba"));
console.log(countALetter("mixer"));