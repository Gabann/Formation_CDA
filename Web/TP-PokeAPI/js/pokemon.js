	export class Pokemon {
		#id;
		sprite;
		#name;
		#height;
		#weight;
		#types;
		#moves;
	
		constructor(id, sprite, name, height, weight, types, moves) {
			this.#id = id;
			this.sprite = sprite;
			this.#name = name;
			this.#height = height;
			this.#weight = weight;
			this.#types = types;
			this.#moves = moves;
		}
	
		get id() {
			return this.#id;
		}
	
		get sprite() {
			return this.sprite;
		}
	
		get name() {
			return this.#name;
		}
	
		get height() {
			return this.#height;
		}
	
		get weight() {
			return this.#weight;
		}
	
		get types() {
			return this.#types;
		}
	
		get moves() {
			return this.#moves;
		}
	}