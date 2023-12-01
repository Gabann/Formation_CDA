let input;

input = Number(prompt("Menu \n" + 
"===============================================\n"+
"Enter the menu item followed by [ENTER]:\n"+
"[1]: Substract\n"+
"[2]: Get hour\n"+
"[-1]: Exit"
));

while (input !== 0){
	switch (input) {
		case 1:
			subtract();
			break;
		case 2:
			getHour();
			break;
		default:
			console.log("Invalid input, try again");
	}

	input = Number(prompt("Menu \n" +
		"===============================================\n"+
		"Enter the menu item followed by [ENTER]:\n"+
		"[1]: Substract\n"+
		"[2]: Get hour\n"+
		"[-1]: Exit"
	));
}