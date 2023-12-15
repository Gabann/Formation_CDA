<script setup>
import {ref} from 'vue';
import {useTodoStore} from "@/store/todoStore.js";

const props = defineProps({
	task: Object,
});

let todoStore = useTodoStore();

function removeTodo() {
	todoStore.taskList = todoStore.taskList.filter(test => test !== props.task);
}
</script>

<template>
	<li>
		{{ task.title }}
		{{ task.description }}

		<button @click="removeTodo">Delete</button>
		<button @click="task.isFavorite = !task.isFavorite">{{ task.isFavorite ? "Unfavorite" : "Favorite" }}</button>
		<button @click="task.isDone = !task.isDone">{{ task.isDone ? "Done" : "Not done" }}</button>
	</li>
</template>

<style scoped>

</style>