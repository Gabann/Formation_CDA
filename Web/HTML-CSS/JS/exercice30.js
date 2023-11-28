import {Chien} from './chien.js'

let animalArray = [];

let chien1 = new Chien("brook", 5, "york");
let chien2 = new Chien("king", 10, "dobber");

animalArray.push(chien1);
animalArray.push(chien2);

for (const animal of animalArray) {
	console.log(animal);
}