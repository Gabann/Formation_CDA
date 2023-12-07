//Ex 01
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

//Ex 02
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

//Ex 03
<!--<script setup>-->

<!--import {ref} from "vue";-->

<!--let isRed = ref(false);-->

<!--function toggleClass() {-->
<!--	isRed.value = !isRed.value;-->
<!--}-->

<!--</script>-->

<!--<template>-->
<!--	<div>-->
<!--		<p @click="toggleClass" :class="{ red: isRed }">Black to red</p>-->
<!--	</div>-->
<!--</template>-->

<!--<style scoped>-->
<!--.red {-->
<!--	color: red;-->
<!--}-->
<!--</style>-->

//Ex 04
<!--<script setup>-->
<!--import {ref} from "vue";-->

<!--let array = ref([]);-->
<!--let displayList = ref(true);-->

<!--function addRandomNumberToArray(array, min = 1, max = 100) {-->
<!--	array.push(Math.floor(Math.random() * (max - min + 1)));-->
<!--}-->

<!--function removeRandomElementFromArray(array) {-->
<!--	if (!array.length) {-->
<!--		return null;-->
<!--	} else {-->
<!--		const randomIndex = Math.floor(Math.random() * array.length);-->
<!--		return array.splice(randomIndex, 1)[0];-->
<!--	}-->
<!--}-->

<!--</script>-->

<!--<template>-->
<!--	<div>-->
<!--		<div v-if="displayList">-->
<!--			<p v-if="array.length > 0">{{ array }}</p>-->
<!--			<p v-else>The list is empty</p>-->
<!--		</div>-->
<!--		<div v-else>-->
<!--			<p>List is hidden</p>-->
<!--		</div>-->

<!--		<br>-->

<!--		<button @click="displayList = !displayList">Toggle list</button>-->
<!--		<button @click="addRandomNumberToArray(array)">Add element</button>-->
<!--		<button @click="removeRandomElementFromArray(array)">Remove element</button>-->
<!--		<button @click="array.reverse()">Reverse list</button>-->
<!--	</div>-->
<!--</template>-->


<!--<style scoped>-->

<!--</style>-->