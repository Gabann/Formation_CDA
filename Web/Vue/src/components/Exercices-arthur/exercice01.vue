<script setup>
import {ref} from "vue";

let h1Value = ref("Default value");

function reverseString(string) {
	return string.split('').reverse().join('');
}

function addCharToEndOfString(string, char) {
	return string + char;
}
</script>

<template>
	<h1>{{ h1Value }}</h1>
	<br>
	<button v-on:click="h1Value = reverseString(h1Value)">Reverse</button>
	<button v-on:click="h1Value = addCharToEndOfString(h1Value, '!')">Add ! to end</button>
	<a v-on:click.prevent href="https://google.com">Link</a>
</template>

<style scoped>

</style>
