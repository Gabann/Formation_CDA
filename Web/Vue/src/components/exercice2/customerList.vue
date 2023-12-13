<script setup>
import CustomerList from "./customerlist.json";
import {ref} from "vue";
import {useRouter} from 'vue-router';

const router = useRouter();
let customerList = ref(CustomerList);
</script>

<template>
	<h1>This page display the client list</h1>

	<div v-for="customer in customerList" class="customer">
		<p>{{ customer.name }}</p>
		<p>{{ customer.email }}</p>
		<p>{{ customer.phone }}</p>
		<button class="btn btn-primary" @click="router.push(`/Customer-details/${customer.id}`)">Details</button>
	</div>
</template>

<style scoped>
.customer {
	border: 1px solid red;
}
</style>