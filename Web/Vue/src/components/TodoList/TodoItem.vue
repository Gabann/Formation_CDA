<script setup>
import {defineProps, ref} from 'vue';

const props = defineProps({
	todo: {
		type: Object,
		required: true,
	},
	index: {
		type: Number,
		required: true
	}
});

let editingTodo = ref(false);
let editedText = ref("");

function toggleEdit(text) {
	editedText.value = text;
	editingTodo.value = !editingTodo.value;
}

const emits = defineEmits(['editTodo']);

function emitEditTodo() {
	emits('editTodo', props.index, editedText.value);
	toggleEdit();
}

</script>

<template>

	<li class="d-flex flex-row justify-content-between my-2">

		<div v-if="!editingTodo">
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
				<button class="btn btn-success mx-2" @click="emitEditTodo">Confirm</button>
				<button class="btn btn-warning mx-2" @click="toggleEdit">Cancel</button>
			</div>
		</div>
	</li>
</template>

<style scoped>

</style>
