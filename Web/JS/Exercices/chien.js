export class Chien {
	#name;
	#age;
	#species;

	constructor(name, age, species) {
		this.#name = name;
		this.#age = age;
		this.#species = species;
	}
	

	get name() {
		return this.#name;
	}

	set name(newName) {
		this.#name = newName;
	}


	get age() {
		return this.#age;
	}

	set age(newAge) {
		this.#age = newAge;
	}

	get species() {
		return this.#species;
	}

	set species(newSpecies) {
		this.#species = newSpecies;
	}

}