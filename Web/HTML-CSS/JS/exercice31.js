import {Person} from './person.js'

let personArray = [];

let person1 = new Person();
person1.firstName = "Gabin";
person1.lastName = "Deboulogne";
person1.age = 25;

let person2 = new Person();
person2.firstName = "Titouan";
person2.lastName = "Test";
person2.age = "Quinze";

personArray.push(person1);
personArray.push(person2);

for (const person of personArray) {
	console.log(person.fullName);
}