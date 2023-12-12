<script setup>
import {ref} from "vue";

let array = ref([]);
let displayList = ref(true);

function addRandomNumberToArray(array, min = 1, max = 100) {
	array.push(Math.floor(Math.random() * (max - min + 1)));
}

function removeRandomElementFromArray(array) {
	if (!array.length) {
		return null;
	} else {
		const randomIndex = Math.floor(Math.random() * array.length);
		return array.splice(randomIndex, 1)[0];
	}
}
</script>

<template>
	<div>
		<button @click='displayList = !displayList'>Toggle list</button>
		<button @click='addRandomNumberToArray(array)'>Add element</button>
		<button @click='removeRandomElementFromArray(array)'>
			Remove element
		</button>
		<button @click='array.reverse()'>Reverse list</button>
	</div>

	<br/>

	<div v-if='displayList'>
		<ul v-if='array.length > 0' v-for='item in array'>
			<li>{{ item }}</li>
		</ul>

		<p v-else>The list is empty</p>
	</div>
	<div v-else>
		<p>List is hidden</p>
	</div>
</template>

<style scoped></style>