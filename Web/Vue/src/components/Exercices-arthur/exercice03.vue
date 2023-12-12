<script setup>

import {ref} from "vue";

let isRed = ref(false);

function toggleClass() {
	isRed.value = !isRed.value;
}

</script>

<template>
	<div>
		<p @click="toggleClass" :class="{ red: isRed }">Black to red</p>
	</div>
</template>

<style scoped>
.red {
	color: red;
}
</style>