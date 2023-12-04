import {Pokemon} from "./pokemon.js";

const baseUrl = "https://pokeapi.co/api/v2/";

let searchButton = document.querySelector(".searchbar button");
let previousButton = document.querySelector("#previous");
let nextButton = document.querySelector("#next");
let currentPokemon;

async function getPokemonByNameOrId(name) {
	try {
		const response = await fetch(baseUrl + "pokemon/" + name);
		const data = await response.json();

		//Used to get 4 randoms moves the pokemon can learn to get a complete move set
		let shuffledMoves = [...data.moves].sort(() => 0.5 - Math.random());
		let moveSet = shuffledMoves.slice(0, 4);

		currentPokemon = new Pokemon(data.id, data.sprites, data.name, data.height, data.weight, data.types, moveSet);
		return currentPokemon;

	} catch (e) {
		console.error(e);
	}
}

async function displayPokemon(pokemonName) {
	try {
		let pokemon = await getPokemonByNameOrId(pokemonName);

		document.querySelector(".pokemon-card").innerHTML = `
		<div class="row text-center" style="height: 80%">
			<div class="col-6">
				<div class="pokemon-img text-center"  style="height: 100%">
					<img src=${pokemon.sprite.front_default}  style="height: 100%"></img>
				</div>
			</div>
			<div class="col-6">
				<div class="pokemon-name">
					${pokemon.name}
				</div>
				<div class="row">
					<div class="pokemon-height col-6">
						${pokemon.height}
					</div>
				<div class="pokemon-weight col-6">
					${pokemon.weight}
				</div>
			</div>

			<div class="pokemon-types"></div>
			</div>
		</div>

		<div class="row pokemon-moves"></div>`;

		pokemon.types.forEach((type) => {
			document.querySelector(".pokemon-types").innerHTML += type.type.name + " ";
		});

		pokemon.moves.forEach((move) => {
			document.querySelector(".pokemon-moves").innerHTML += move.move.name + " ";
		});
	} catch (e) {
		console.error(e);
	}
}

searchButton.addEventListener("click", () => {
	displayPokemon(document.querySelector("#searchbar-input").value);
});

previousButton.addEventListener("click", () => {
	displayPokemon(currentPokemon.id - 1);
});

nextButton.addEventListener("click", () => {
	displayPokemon(currentPokemon.id + 1);
});

displayPokemon(79);

async function getPokedexByGeneration(generationNumber) {

	try {
		const response = await fetch(baseUrl + "generation/" + generationNumber);
		const data = await response.json();
		console.log();
	} catch (e) {
		console.error(e);
	}
}

getPokedexByGeneration(1);