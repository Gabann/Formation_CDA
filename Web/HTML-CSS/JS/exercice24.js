function askForNumberInput(promptMessage, minValue, maxValue = Infinity, promptMessageOnError = "Erreur de saisie, réessayez: \n" + promptMessage){
	let input;

	input = Number(prompt(promptMessage));

	while (!validateNumberInput(input, minValue,maxValue)){
		input = Number(prompt(promptMessageOnError));
	}

	return input;
}

function validateNumberInput(input, min , max) {
	if (input < min || input > max || input === undefined || isNaN(input)) return false;
	else return true;
}

function askForStringInput(promptMessage, promptMessageOnError = "Erreur de saisie, réessayez: \n" + promptMessage){
	let str;
	
	str = prompt(promptMessage);
	
	str = formatString(str);
	
	return str;
}

//There should be no number in a name and should be at least 2 characters longs
function validateContactName(str){
	if (str.length < 2 || (/\d/.test(str))) return false;
	else return true;
}

function formatString(str) {
	str = str.trim();
	return  str.charAt(0).toUpperCase() + str.slice(1).toLowerCase();
}

function addContact(contact){
	if (contact === undefined || !validateContactName(contact)){
		contact = askForStringInput("Nom du contact");
	}
	
	contact = formatString(contact);
	
	if (contactArray.includes(contact)){
		console.log(`${contact} is already in the contact list`);
		return;
	}

	contactArray.push(contact);
	console.log(`${contact} a été ajouté`);
}

function removeContact(contact) {
	if (contact === undefined) {
		contact = askForStringInput("Entrez le nom du contact a supprimer");
	}

	contact = formatString(contact);

	var index = contactArray.indexOf(contact);
	if (index !== -1) {
		contactArray.splice(index, 1);
		console.log(`${contact} a été supprimé`);
	}
	else console.log("Contact non trouvé, rien n'a été supprimé");
}

function searchContactByName(nameSearchQuery) {
	if (nameSearchQuery === undefined) {
		nameSearchQuery = askForStringInput("Entrez le nom du contact a rechercher");
	}
	
	let matchingContactArray = [];

	for (let i = 0; i < contactArray.length; i++) {
		if (contactArray[i].includes(nameSearchQuery)) {
			matchingContactArray.push(contactArray[i]);
		}
	}

	if (matchingContactArray.length <= 0){
		console.log(`Aucun contact en ${nameSearchQuery} n'a été trouvé`);
	}
	else{
		console.log(`Liste des contacts trouvés ${matchingContactArray}`);
	}
}

function displayMenu() {
	let inputMode;
	
	do {
		inputMode = askForNumberInput("Choisir mode de saisie:\n1 : Saisir les contacts:\n2 : Afficher les contacts\n3 : Trier les" +
			" contacts par ordre alphabétique\n4 : Mélanger les contacts\n5 : Supprimer un contact\n6 : Rechercher un contact\n0 : Quitter"
			, 0, 7);

		switch (inputMode) {
			case 1:
				contactArray = [];
				for (let i = 0; i < contactCount; i++) {
					addContact();
				}
				break;
			case 2:
				console.log(contactArray);
				break;
			case 3:
				contactArray.sort();
				break;
			case 4:
				contactArray.sort(() => Math.random() - 0.5);
				break;
			case 5:
				removeContact();
				break;
			case 6:
				searchContactByName();
				break;
			case 0:
				break;
		}
	}
	while (inputMode !== 0);
}

const names = ["Emma", "Liam", "Olivia", "Noah", "Ava", "Isabella", "Sophia", "Jackson", "Mia", "Lucas", "Harper", "Evelyn", "Alexander", "Abigail", "Ella", "Michael", "James", "Benjamin", "Daniel", "Grace", "Madison", "Emily", "David", "Joseph", "Gabriel", "Aiden", "Chloe", "Elijah", "Leah", "Sofia", "Caden", "Ella", "Logan", "Nora", "Avery", "Mason", "Eleanor", "Penelope", "Carter", "Riley", "Leo", "Lucy", "Jack", "Hazel", "Ryan", "Layla", "Isaac", "Luna", "Sebastian", "Zoe", "Luke", "Stella", "Wyatt", "Lillian", "Jayden", "Paisley", "Adam", "Naomi", "Nathan", "Violet", "Julian", "Aria", "Isaiah", "Scarlett", "Owen", "Allison", "Caleb", "Grace", "Henry", "Aurora", "Eli", "Skylar", "Levi", "Claire", "Landon", "Bella", "Asher", "Audrey", "Hudson", "Savannah", "Grayson", "Anna", "Ezra", "Aaliyah", "Theodore", "Ariana"];

function addRandomName() {
	addContact(names[Math.floor(Math.random() * names.length)]);
}

let contactArray = [];

let contactCount = askForNumberInput("Combien de contacts", 1);
for (let i = 0; i < contactCount; i++) {
	addRandomName();
}

displayMenu();