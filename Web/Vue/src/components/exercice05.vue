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
let taskArray = ref([]);
let priorityFilter = ref(new Filter('priority', ''));
let isDoneFilter = ref(new Filter('isDone', ''));

let filteredTaskArray = computed(() => {
	let filteredArray = [...taskArray.value];

	for (const filter of filtersArray) {
		console.log(filter.property);
		console.log(filter.filter);
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

	console.log(filtersArray);
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