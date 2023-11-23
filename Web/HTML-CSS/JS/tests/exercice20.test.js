const {getProportion, verifyInput} = require('../exercice20');

test('Test if the adn percenteage is correct', () => {
	expect(getProportion("act", "gtc")).toBe(0);
	expect(getProportion("acac", "acac")).toBe(1);
	expect(getProportion("actgtagt", "ac")).toBe(2/8);
	expect(getProportion("actgtagt", "tgt")).toBe(3/8);
	expect(getProportion("actgactgaa", "actgactg")).toBe(8/10);
	
	//Checks for sequence repeating multiple times but with non-matching sequence in the middle
	expect(getProportion("acatac", "ac")).toBe(4/6);
	
	//Checks for case insensitivity
	expect(getProportion("ACaTaC", "ac")).toBe(4/6);
	
	//Checks for whitespaces removal
	expect(getProportion("   actgactgaa  ", "actgactg")).toBe(8/10);
	expect(getProportion(" actgactgaa", "actgactg   ")).toBe(8/10);
	expect(getProportion("   act   ", "gtc")).toBe(0);
	expect(getProportion("actga ctgaa", "actga")).toBe(5/10);
});

test('Test is the input is valid', () => {
	expect(verifyInput("actgactgaa")).toBe(true);
	expect(verifyInput("acatac")).toBe(true);
	
	//Checks for case insensitivity
	expect(verifyInput("ACTgtagT")).toBe(true);
	
	//Checks for whitespace removal
	expect(verifyInput("   actgactgaa")).toBe(true);
	expect(verifyInput("actgac   tgaa")).toBe(true);

	//Checks for forbidden characters
	expect(verifyInput("zriegfdsjdfhs")).toBe(false);
	expect(verifyInput("iuq")).toBe(false);
});