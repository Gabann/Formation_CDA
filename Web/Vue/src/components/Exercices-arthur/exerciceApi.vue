<template>
	<div>
		<form @submit.prevent='searchCard(searchedCardName)'>
			<input type="text" v-model="searchedCardName">
		</form>
	</div>

	<div v-if="currentCard">
		<p>{{ currentCard.data[0].name }}</p>
		<br>

		<p>{{ currentCard.data[0].type }}</p>
		<br>

		<p>{{ currentCard.data[0].desc }}</p>
		<br>

		<p>{{ currentCard.data[0].atk }}</p>
		<br>

		<p>{{ currentCard.data[0].def }}</p>
		<br>
	</div>
</template>

<script setup>
import {ref} from "vue";

const apiUrl = 'https://db.ygoprodeck.com/api/v7/cardinfo.php?name=';
let searchedCardName = ref();
let currentCard = ref();

async function searchCard(cardName) {
	const response = await fetch(apiUrl + cardName);
	currentCard.value = await response.json();
}
</script>

<style scoped>

</style>