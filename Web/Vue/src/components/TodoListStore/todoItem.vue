<script setup>
import {ref} from 'vue';

const props = defineProps({
	task: Object,
	todoItemStore: Object
});

function removeTodo() {
	props.todoItemStore.taskList = props.todoItemStore.taskList.filter(test => test !== props.task);
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