<script setup>
import {defineEmits, defineProps, ref} from "vue";
import {User} from "./UserClass.js"

const props = defineProps({
	user: {
		type: User,
		required: true,
	},
	index: {
		type: Number,
		required: true
	}
});

const emits = defineEmits(['edit-user']);

function toggleEdit(username, email) {
	editedUserName.value = username;
	editedUserEmail.value = email;
	editingTodo.value = !editingTodo.value;
}

let editingTodo = ref(false);
let editedUserName = ref('');
let editedUserEmail = ref('');

function emitEditUser(index, newUsername, newUserEmail) {
	emits('edit-user', index, newUsername, newUserEmail);
	toggleEdit();
}

</script>

<template>
	<tr v-if="!editingTodo">
		<td>{{ user.username }}</td>
		<td>{{ user.email }}</td>
		<td>
			<button class="btn btn-warning" @click="toggleEdit(user.username, user.email)">Edit</button>
			<button class="btn btn-danger" @click="$emit('remove-user', index)">Delete</button>
		</td>
	</tr>
	<tr v-else>
		<td>
			<input v-model="editedUserName" type="text">
		</td>
		<td>
			<input v-model="editedUserEmail" type="text">
		</td>
		<td>
			<button class="btn btn-success" @click="emitEditUser(index, editedUserName, editedUserEmail)">Confirm</button>
			<button class="btn btn-warning" @click="toggleEdit">Cancel</button>
		</td>
	</tr>
</template>

<style scoped>
</style>