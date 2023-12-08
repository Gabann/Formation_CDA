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

//Ex 05
<template>
	<div>
		<form @submit.prevent='addTask(title, description, priority)'>
			<input type='text' name='todo-list-title' id='todo-list-title' placeholder='Title' v-model='title'>
			<textarea rows='4' style='resize: none' v-model='description' placeholder="Description"></textarea>

			<select v-model='priority'>
				<option selected>Low</option>
				<option>Medium</option>
				<option>High</option>
			</select>

			<button type='submit'>Add</button>
		</form>

		<div>
			<label for='priority-filter'></label>
			<select id='priority-filter' v-model='priorityFilter.filter'>
				<option value="" disabled selected>Priority filter</option>
				<option>Low</option>
				<option>Medium</option>
				<option>High</option>
			</select>

			<label for='is-done-filter'></label>
			<select id='is-done-filter' v-model='isDoneFilter.filter'>
				<option value="" disabled selected>Done filter</option>
				<option :value=true>Done</option>
				<option :value=false>Not done</option>
			</select>
		</div>

		<div>
			<table>
				<thead>
					<tr>
						<th>Title</th>
						<th>Description</th>
						<th>Priority</th>
						<th>Done status</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr v-for='(task) in filteredTaskArray'>
						<td>{{ task.title }}</td>
						<td>{{ task.description }}</td>
						<td>{{ task.priority }}</td>
						<td>
							<label for='scales'>Done?</label>
							<input type='checkbox' name='is-done' checked='{{task.isDone}}' v-model="task.isDone"/>
						</td>
						<button v-on:click='deleteItemFromArray(taskArray, task)'>Delete</button>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</template>

<script setup>
import {ref, watch, onMounted, computed} from "vue";

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

class Filter {
	property;
	filter;

	constructor(property, filter) {
		this.property = property;
		this.filter = filter;
	}
}

let title = ref("");
let description = ref("");
let priority = ref("Low");
let filtersArray = [];
let priorityFilter = ref(new Filter('priority', ''));
let isDoneFilter = ref(new Filter('isDone', ''));
let taskArray = ref([]);

let filteredTaskArray = computed(() => {
	let filteredArray = [...taskArray.value];

	for (const filter of filtersArray) {
		filteredArray = filterTaskList(filteredArray, filter.property, filter.filter);
	}

	return filteredArray;
});

onMounted(() => {
	let storedTasks = localStorage.getItem('tasks');
	if (storedTasks) {
		taskArray.value = JSON.parse(storedTasks);
	}
	window.addEventListener('beforeunload', () => {
		localStorage.setItem('tasks', JSON.stringify(taskArray.value));
	});
});

watch([() => priorityFilter.value.filter, () => isDoneFilter.value.filter], (newVal, oldVal) => {
	toggleFilter(oldVal);
	toggleFilter(newVal);
});

function addTask(title, description, priority) {
	if (!title || !description || !priority) {
		console.error("All params must be set");
		return null;
	}

	let newTask = new Task(title, description, priority);
	taskArray.value.push(newTask);
}

function toggleFilter(filter) {
	const index = filtersArray.indexOf(filter);
	if (index === -1) {
		filtersArray.push(filter);
	} else {
		filtersArray.splice(index, 1);
	}

	// console.log(filtersArray);
}

function filterTaskList(array, property, filter) {
	return array.value.filter((task) => task[property] === filter);
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

//Ex API
<!--<template>-->
<!--	<div>-->
<!--		<form @submit.prevent='searchCard(searchedCardName)'>-->
<!--			<input type="text" v-model="searchedCardName">-->
<!--		</form>-->
<!--	</div>-->

<!--	<div v-if="currentCard">-->
<!--		<p>{{ currentCard.data[0].name }}</p>-->
<!--		<br>-->

<!--		<p>{{ currentCard.data[0].type }}</p>-->
<!--		<br>-->

<!--		<p>{{ currentCard.data[0].desc }}</p>-->
<!--		<br>-->

<!--		<p>{{ currentCard.data[0].atk }}</p>-->
<!--		<br>-->

<!--		<p>{{ currentCard.data[0].def }}</p>-->
<!--		<br>-->
<!--	</div>-->
<!--</template>-->

<!--<script setup>-->
<!--import {ref} from "vue";-->

<!--const apiUrl = 'https://db.ygoprodeck.com/api/v7/cardinfo.php?name=';-->
<!--let searchedCardName = ref();-->
<!--let currentCard = ref();-->

<!--async function searchCard(cardName) {-->
<!--	const response = await fetch(apiUrl + cardName);-->
<!--	currentCard.value = await response.json();-->
<!--}-->
<!--</script>-->

<!--<style scoped>-->

<!--</style>-->