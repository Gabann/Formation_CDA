<script setup>
import {useTodoStore} from "@/store/todo.js";
import {reactive, ref, watch} from "vue";
import {Filter} from "@/components/TodoListStore/Filter.js";

let todoItemStore = useTodoStore();
let taskTitle = ref("");
let taskDescription = ref("");

let favoriteFilter = ref(new Filter('isFavorite', ''));
let doneFilter = ref(new Filter('isDone', ''));

</script>

<template>
	<h1>To Do</h1>

	<input type="text" name="todo-title-input" id="todo-title-input" v-model="taskTitle" placeholder="Title">
	<input type="text" name="todo-description-input" id="todo-description-input" v-model="taskDescription" placeholder="Description">
	<button @click="todoItemStore.addTodo(taskTitle, taskDescription)">Add</button>

	<label for='favorite-filter'></label>
	<select id='favorite-filter' v-model="favoriteFilter.filter" @change="todoItemStore.addFilter(favoriteFilter)">
		<option value="" disabled selected>Favorite filter</option>
		<option :value=null>All</option>
		<option :value=true>Favorite</option>
		<option :value=false>Unfavorite</option>
	</select>

	<label for='done-filter'></label>
	<select id='done-filter' v-model="doneFilter.filter" @change="todoItemStore.addFilter(doneFilter)">
		<option value="" disabled selected>Done filter</option>
		<option :value=null>All</option>
		<option :value=true>Done</option>
		<option :value=false>Not done</option>
	</select>

	<ul>
		<li v-for="task in todoItemStore.filteredTaskArray">
			{{ task.title }}
			{{ task.description }}

			<button @click="todoItemStore.removeTodoByTitle(task.title)">Delete</button>
			<button @click="todoItemStore.favoriteTodoTaskByTitle(task.title)">{{ task.isFavorite ? "Unfavorite" : "Favorite" }}</button>
			<button @click="todoItemStore.doTodoTaskByTitle(task.title)">{{ task.isDone ? "Done" : "Not done" }}</button>
		</li>
	</ul>
</template>

<style scoped>

</style>