<script setup>
import {ref} from "vue";

import AddUser from "@/components/addUser.vue";
import UserListItem from "@/components/userListItem.vue";
import TodoItem from "@/components/TodoItem.vue";

const userArray = ref([]);
let alertMessage = ref('');
let alertLevel = ref('');

const addUser = (user) => {
	if (validateInput(user.username, user.email))
		userArray.value.push(user);
};

const removeUser = (index) => {
	userArray.value.splice(index, 1);
};

const editUser = (index, username, email) => {
	if (validateInput(username, email)) {
		userArray.value[index].username = username;
		userArray.value[index].email = email;
	}
};

function validateInput(username, email) {
	if (!username || !email) {
		alertMessage.value = "Please fill both username and email";
		alertLevel.value = "alert-danger";
		return false;
	}

	if (username.length < 3) {
		alertMessage.value = "Username should be at least 3 characters long";
		alertLevel.value = "alert-danger";
		return false;
	}

	const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

	if (!emailRegex.test(email)) {
		alertMessage.value = "Enter a valid email";
		alertLevel.value = "alert-danger";
		return false;
	}

	alertMessage.value = "User added";
	alertLevel.value = "alert-success";
	return true;
}

function alert(type, message) {

}
</script>

<template>
	<div>
		<AddUser @add-user="addUser"></AddUser>

		<div v-if="alertMessage" v-bind:class="alertLevel" class="alert" role="alert">
			{{ alertMessage }}
		</div>

		<div v-if="userArray.length">
			<table>
				<thead>
					<tr>
						<th>Username</th>
						<th>Email</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<UserListItem v-for="(user, index) in userArray"
					              :user="user"
					              :index=index
					              @remove-user="removeUser"
					              @edit-user="editUser"/>
				</tbody>
			</table>

		</div>
	</div>
</template>

<style scoped>
table {
	width: 100%;
	border-collapse: collapse;
}

th, td {
	border: 1px solid #ddd;
	padding: 8px;
}

th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}
</style>