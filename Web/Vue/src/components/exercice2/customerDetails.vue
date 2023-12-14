<script setup>
import {reactive, ref} from "vue";
import {useRouter, useRoute} from 'vue-router';

const router = useRouter();
const route = useRoute();
const userId = route.params.id;
let customer = reactive({});

import(`./customer${userId}.json`).then(function (importedCustomer) {
	customer.value = importedCustomer;
});
</script>

<template>
	<div v-if="customer">
		<h1>Client details</h1>

		<ul>
			<li v-for="customerInfo in customer">
				<h2>{{ customerInfo.name }}</h2>
				<p>Email: {{ customerInfo.email }}</p>
				<p>Phone: {{ customerInfo.phone }}</p>
				<p>City: {{ customerInfo.city }}</p>
				<p>State: {{ customerInfo.state }}</p>
				<p>Country: {{ customerInfo.country }}</p>
				<p>Organization: {{ customerInfo.organization }}</p>
				<p>Job Profile: {{ customerInfo.jobProfile }}</p>
				<p>Additional Info: {{ customerInfo.additionalInfo }}</p>
			</li>
		</ul>

		<button class="btn btn-primary" @click="router.push(`/Customer-list`)">Back</button>
	</div>
</template>

<style scoped>

</style>