<script setup>
class Person {
	firstName;
	lastName;
	dob;

	constructor(firstName, lastName, dob) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}

	get age() {
		//Get the number of ms between now and the dob
		let msDifference = Date.now() - this.dob;
		//We have to subtract 1970 to the year because a date is based on the number of ms since 01/01/1970
		return new Date(msDifference).getFullYear() - 1970;
	}
}

import {reactive} from "vue";

//Remember a month is between 0 and 11 because js is stupid
let person = reactive(new Person('Gabin', 'Deboulogne', new Date(1998, 8, 8)));

function add1Year() {
	//Does not work because the reactive is not triggered
	// person.dob.setFullYear(person.dob.getFullYear() - 1);

	let newDate = new Date(person.dob);

	newDate.setFullYear(person.dob.getFullYear() - 1);

	person.dob = newDate;
}

</script>

<template>
	<h1>{{ person.age }}</h1>

	<br>

	<button @click="add1Year">Add 1 year</button>
</template>

<style scoped>

</style>