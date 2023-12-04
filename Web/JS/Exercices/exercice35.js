class Character {
	#name;
	#hp;
	#strength;

	constructor(name, health, strength) {
		this.#name = name;
		this.#hp = health;
		this.#strength = strength;
	}

	attack(target) {
		target.takeDamages(this.#strength);
	}

	takeDamages(amount) {
		this.#hp -= amount;
		console.log(`${this.#name} takes ${amount} damages and is now at ${this.#hp} hp`);

		if (this.#hp <= 0) {
			this.#die();
		}
	}

	heal(amount) {
		console.log(`${this.#name} heals from ${this.#hp} to ${(this.#hp + amount)} hp`);
		this.#hp += amount;
	}

	#die() {
		//TODO implement method die
		console.log(`${this.#name} died`);
	}

	get name() {
		return this.#name;
	}

	get hp() {
		return this.#hp;
	}

	get strength() {
		return this.#strength;
	}
}

class Warrior extends Character {
	armor;

	constructor(name, health, strength, armor) {
		super(name, health, strength);
		this.armor = armor;
	}

	attack(target) {
		let damages = this.armor + this.strength;

		target.takeDamages(damages);
	}

	get hp() {
		return super.hp + this.armor;
	}
}

class Wizard extends Character {
	mana;

	constructor(name, health, strength, mana) {
		super(name, health, strength);
		this.mana = mana;
	}

	attack(target) {
		let damages = this.strength + this.mana;

		target.takeDamages(damages);
	}

	healTarget(target) {
		target.heal(this.mana);
	}
}

let wizard = new Wizard("Eda", 15, 5, 10);
let warrior = new Warrior("King", 15, 5, 20);

let target = new Character("Random npc", 20, 3);

wizard.attack(target);
wizard.healTarget(target);

console.log(warrior.hp);