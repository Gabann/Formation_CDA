<!--<script setup>-->


<!--let h1Value = ref("Default value");-->

<!--function reverseString(string) {-->
<!--	return string.split('').reverse().join('');-->
<!--}-->

<!--function addCharToEndOfString(string, char) {-->
<!--	return string + char;-->
<!--}-->
<!--</script>-->

<!--<template>-->
<!--	<h1>{{ h1Value }}</h1>-->
<!--	<br>-->
<!--	<button v-on:click="h1Value = reverseString(h1Value)">Reverse</button>-->
<!--	<button v-on:click="h1Value = addCharToEndOfString(h1Value, '!')">Add ! to end</button>-->
<!--	<a v-on:click.prevent href="https://google.com">Link</a>-->
<!--</template>-->

<!--<style scoped>-->

<!--</style>-->

<!--<script setup>-->
<!--class Person {-->
<!--	firstName;-->
<!--	lastName;-->
<!--	dob;-->


<!--	constructor(firstName, lastName, dob) {-->
<!--		this.firstName = firstName;-->
<!--		this.lastName = lastName;-->
<!--		this.dob = dob;-->
<!--	}-->

<!--	get age() {-->
<!--		//Get the number of ms between now and the dob-->
<!--		let msDifference = Date.now() - this.dob;-->
<!--		//We have to subtract 1970 to the year because a date is based on the number of ms since 01/01/1970-->
<!--		return new Date(msDifference).getFullYear() - 1970;-->
<!--	}-->
<!--}-->

<!--import {reactive} from "vue";-->

<!--//Remember a month is between 0 and 11 because js is stupid-->
<!--let person = reactive(new Person('gabin', 'deboulogne', new Date(1998, 8, 8)));-->

<!--function add1Year() {-->
<!--	//Does not work because the reactive is not triggered-->
<!--	// person.dob.setFullYear(person.dob.getFullYear() - 1);-->

<!--	let newDate = new Date(person.dob);-->

<!--	newDate.setFullYear(person.dob.getFullYear() - 1);-->

<!--	person.dob = newDate;-->
<!--}-->

<!--</script>-->

<!--<template>-->
<!--	<h1>{{ person.age }}</h1>-->

<!--	<br>-->

<!--	<button @click="add1Year">Add 1 year</button>-->
<!--</template>-->

<!--<style scoped>-->

<!--</style>-->

<script setup>
import {ref, computed} from 'vue';

let numbers = ref([1, 4, 12, 16, 15, 4]);

let nombrePairs = computed(() => {
	return numbers.value.filter(n => n % 2 === 0).length;
});

function addToNumbers() {
	numbers.value.push(Math.floor(Math.random() * 100));
}

</script>

<template>
	<h1>Voici des nombres</h1>
	<p>{{ numbers.toString() }}</p>
	<h2>Il y a {{ nombrePairs }} dans ce tableau</h2>
	<button v-on:click="addToNumbers">Ajouter un nombre</button>
</template>

<style scoped></style>