<script setup>
import {ref, defineEmits} from 'vue';
import {User} from "@/components/UserList/UserClass.js";

const emit = defineEmits(['add-user']);

const newUsername = ref("");
const newUserEmail = ref("");

function emitAddUser() {
	emit('add-user', new User(newUsername.value, newUserEmail.value));
	newUsername.value = "";
	newUserEmail.value = "";
}
</script>

<template>
	<div>
		<form @submit.prevent="emitAddUser">
			<input v-model="newUsername" type="text" name="username" id="username" placeholder="username">
			<input v-model="newUserEmail" type="email" name="email" id="email" placeholder="email">
			<button class="btn btn-primary" type="submit">Add user</button>
		</form>
	</div>
</template>

<style scoped>

</style>