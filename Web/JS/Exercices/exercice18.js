function isPalindrome(str){
	let start = 0, end = str.length;
	
	while (start < str.length / 2 + 1){
		if (str.charAt(start) === str.charAt(end - 1)){
			start++;
			end--;
		}
		else return false;

	}
	return true;
}

console.log(isPalindrome("non"));
console.log(isPalindrome("touot"));
console.log(isPalindrome("toot"));
console.log(isPalindrome("pierre"));