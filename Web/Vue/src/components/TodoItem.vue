<script setup>
import {defineProps, ref} from 'vue';

const props = defineProps({
	todo: {
		type: String,
		required: true,
	},
	index: {
		type: Number,
		required: true
	}
});

let editTodo = ref(false);
let editedText = ref("");

function toggleEdit(text) {
	editedText.value = text;
	editTodo.value = !editTodo.value;
}

</script>

<template>

	<ul>
		<li class="d-flex flex-row justify-content-between my-2">
			<!--		<div v-if='!editTodo'>-->
			<!--			{{ todo.text }}-->
			<!--		</div>-->
			<!--		<div v-else-if="editTodo">-->
			<!--			<input v-model="editedText" type="text">-->
			<!--		</div>-->
			<!--		<div>-->
			<!--			<button v-if="!editTodo" class="btn btn-primary mx-2" @click="editTodo = !editTodo">Edit</button>-->
			<!--			<button v-else class="btn btn-warning mx-2" @click="editTodo = !editTodo">Cancel</button>-->
			<!--			<button v-else class="btn btn-success mx-2" @click="$emit('editTodo', index, editedText)">Confirm</button>-->

			<!--			<button class="btn btn-danger mx-2" @click="$emit('remove-todo', index)">Remove</button>-->
			<!--		</div>-->

			<div v-if="!editTodo">
				<div>
					{{ todo.text }}
				</div>

				<div>
					<button class="btn btn-primary mx-2" @click="toggleEdit(todo.text)">Edit</button>

					<button class="btn btn-danger mx-2" @click="$emit('remove-todo', index)">Remove</button>
				</div>
			</div>
			<div v-else>
				<div>
					<input v-model="editedText" type="text">
				</div>

				<div>
					<button class="btn btn-success mx-2" @click="$emit('editTodo', index, editedText)">Confirm</button>
					<button class="btn btn-warning mx-2" @click="toggleEdit">Cancel</button>

					<button class="btn btn-danger mx-2" @click="$emit('remove-todo', index)">Remove</button>
				</div>
			</div>
		</li>
	</ul>
</template>

<style scoped>

</style>
