export class Person {
	#firstName;
	#lastName;
	#age;

	constructor(firstName, lastName, age) {
		this.#firstName = firstName;
		this.#lastName = lastName;
		this.#age = age;
	}

	set firstName(newFirstName) {
		newFirstName = newFirstName.trim();
		newFirstName = newFirstName.charAt(0).toUpperCase() + newFirstName.slice(1).toLowerCase();


		if (newFirstName !== "Titouan")
			this.#firstName = newFirstName;
		else
			console.log("Change de nom et porte plainte contre tes parents");
	}

	set age(newAge) {
		if (!isNaN(newAge))
			this.#age = newAge;
		else
			console.log("Age doit etre un nombre");
	}

	getFullName() {
		return `${this.#firstName} ${this.#lastName}`;
	}
}