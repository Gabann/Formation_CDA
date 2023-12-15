<script setup>
import {useTodoStore} from "@/store/todoStore.js";
import {reactive, ref} from "vue";
import {Filter} from "@/components/TodoListStore/Filter.js";
import TodoItem from "@/components/TodoListStore/todoItem.vue";

let todoStore = useTodoStore();
let taskTitle = ref("");
let taskDescription = ref("");

let favoriteFilter = ref(new Filter('isFavorite', ''));
let doneFilter = ref(new Filter('isDone', ''));

function addTask(title, description) {
	taskTitle = '';
	taskDescription = '';
	todoStore.addTask(title, description);
}
</script>

<template>
	<h1>To Do</h1>

	<input type="text" name="todo-title-input" id="todo-title-input" v-model="taskTitle" placeholder="Title">
	<input type="text" name="todo-description-input" id="todo-description-input" v-model="taskDescription" placeholder="Description">
	<button @click="addTask(taskTitle, taskDescription)">Add</button>

	<label for='favorite-filter'></label>
	<select id='favorite-filter' v-model="favoriteFilter.filter" @change="todoStore.addFilter(favoriteFilter)">
		<option value="" disabled selected>Favorite filter</option>
		<option :value=null>All</option>
		<option :value=true>Favorite</option>
		<option :value=false>Unfavorite</option>
	</select>

	<label for='done-filter'></label>
	<select id='done-filter' v-model="doneFilter.filter" @change="todoStore.addFilter(doneFilter)">
		<option value="" disabled selected>Done filter</option>
		<option :value=null>All</option>
		<option :value=true>Done</option>
		<option :value=false>Not done</option>
	</select>

	<ul v-for="task in todoStore.filteredTaskArray">
		<TodoItem :task="task" :todoItemStore="todoStore"/>
	</ul>
</template>

<style scoped>

</style>