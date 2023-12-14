<script setup>
import CustomerDisplay from "@/components/exercice2/customerDetails.vue";
import CustomerList from "@/components/exercice2/customerList.vue";

import {RouterLink, RouterView} from 'vue-router';
</script>

<template>
	<li>
		<RouterLink to="/Customer-list">Home</RouterLink>
	</li>

	<RouterView/>
</template>

<style scoped>

</style>