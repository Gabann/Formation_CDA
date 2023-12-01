export class Person {
	#firstName;
	#lastName;
	#dob;
	#id;

	static count = 0;

	constructor(firstName, lastName, dob) {
		if (validateNameInput(firstName) && validateNameInput(lastName)) {
			this.#id = ++Person.count;
			this.#firstName = firstName;
			this.#lastName = lastName;
			this.#dob = dob;
		} else {
			throw new Error("Wrong name input");
		}
	}

	get firstName() {
		return this.#firstName;
	}

	set firstName(newFirstName) {
		if (validateNameInput(newFirstName)) {
			newFirstName = newFirstName.trim();
			newFirstName = newFirstName.charAt(0).toUpperCase() + newFirstName.slice(1).toLowerCase();
			this.#firstName = newFirstName;
		}
	}

	get lastName() {
		return this.#lastName;
	}

	get fullName() {
		return `${this.#firstName} ${this.#lastName}`;
	}

	get dob() {
		return this.#dob;
	}

	get id() {
		return this.#id;
	}
}

// Username should only contain letters and numbers and be at least 2 char long
function validateNameInput(str) {
	if (typeof str !== 'string') {
		return false;
	}

	const regex = /^[a-zA-Z0-9]{2,}$/;
	return regex.test(str);
}