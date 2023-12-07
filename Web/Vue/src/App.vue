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
<!--let person = reactive(new Person('Gabin', 'Deboulogne', new Date(1998, 8, 8)));-->

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
<!--import { ref } from "vue";-->

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
<!--		<button @click='displayList = !displayList'>Toggle list</button>-->
<!--		<button @click='addRandomNumberToArray(array)'>Add element</button>-->
<!--		<button @click='removeRandomElementFromArray(array)'>-->
<!--			Remove element-->
<!--		</button>-->
<!--		<button @click='array.reverse()'>Reverse list</button>-->
<!--	</div>-->

<!--	<br />-->

<!--	<div v-if='displayList'>-->
<!--		<ul v-if='array.length > 0' v-for='item in array'>-->
<!--			<li>{{ item }}</li>-->
<!--		</ul>-->

<!--		<p v-else>The list is empty</p>-->
<!--	</div>-->
<!--	<div v-else>-->
<!--		<p>List is hidden</p>-->
<!--	</div>-->
<!--</template>-->

<!--<style scoped></style>-->

<template>
	<div>
		<form @submit.prevent='addTask(title, description, priority)'>
			<input type='text' name='todo-list-title' id='todo-list-title' placeholder='Title' v-model='title'>
			<textarea rows='4' style='resize: none' v-model='description'></textarea>

			<select v-model='priority'>
				<option>Low</option>
				<option>Medium</option>
				<option>High</option>
			</select>

			<button type='submit'>Add</button>

		</form>

		<div>
			<label for='filter'></label>
			<select id='filter' v-on:change='filterArray(taskArray, filter)' v-model='filter'>
				<option>Low</option>
				<option>Medium</option>
				<option>High</option>
			</select>
		</div>

		<div>
			<table>
				<thead>
					<tr>
						<th>Title</th>
						<th>Description</th>
						<th>Priority</th>
					</tr>
				</thead>
				<tbody>
					<tr v-for='(task) in taskArray'>
						<td>{{ task.title }}</td>
						<td>{{ task.description }}</td>
						<td>{{ task.priority }}</td>
						<td>
							<label for='scales'>Done?</label>
							<input type='checkbox' name='is-done' checked='{{task.isDone}}' />
						</td>
						<button v-on:click='deleteItemFromArray(taskArray, task)'>Delete</button>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</template>

<script setup>
import { ref } from "vue";

let title = ref("");
let description = ref("");
let priority = ref("");
let filter = ref("");
let taskArray = ref([]);

class Task {
	title;
	description;
	priority;
	isDone = false;

	constructor(title, description, priority) {
		this.title = title;
		this.description = description;
		this.priority = priority;
	}
}


function addTask(title, description, priority) {
	if (!title || !description || !priority) {
		console.error("All params must be set");
		return null;
	}

	let newTask = new Task(title, description, priority);
	taskArray.value.push(newTask);
}

function filterArray(taskList, filter) {
	taskArray.value = taskList.filter((task) => task.priority === filter);
}

function deleteItemFromArray(array, itemToRemove) {
	taskArray.value = array.filter((item) => item !== itemToRemove);

	console.log(taskArray.value);
}

</script>

<style scoped>
form {
	display: flex;
	width: 300px;
	margin: 0 auto;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	font-family: Arial, sans-serif;
}

form input[type='text'], form select, textarea {
	margin: 10px;
	padding: 10px;
	border: 1px solid #ddd;
	border-radius: 3px;
	font-size: 16px;
}

form button {
	padding: 10px;
	border: none;
	border-radius: 3px;
	background-color: #008CBA;
	color: white;
	cursor: pointer;
	font-size: 16px;
}

form button:hover {
	background-color: #007B9A;
}

table {
	width: 100%;
	border-collapse: collapse;
	font-family: Arial, sans-serif;
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.2);
	transition: 0.3s;
}

table thead th {
	background-color: #008CBA;
	color: white;
	text-align: left;
	padding: 16px;
}

table tbody td {
	border-bottom: 1px solid #ddd;
	padding: 8px;
	text-align: left;
}

table tbody tr:nth-child(even) {
	background-color: #f2f2f2;
}

table tbody tr:hover {
	background-color: #ddd;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}
</style>