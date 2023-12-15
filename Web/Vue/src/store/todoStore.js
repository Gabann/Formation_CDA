import {defineStore} from "pinia";
import {Task} from "@/components/TodoListStore/Task.js";
import {computed, ref} from "vue";

export const useTodoStore = defineStore('todoItem', () => {
	let taskList = ref([]);
	let filterArray = ref([]);

	function addTask(title, description) {
		let todoTask = new Task(title, description, false, false);

		taskList.value.push(todoTask);
	}

	let filteredTaskArray = computed(() => {
		let filteredArray = [...taskList.value];

		for (const filter of filterArray.value) {
			filteredArray = filterTaskList(filteredArray, filter.property, filter.filter);
		}

		return filteredArray;
	});

	function addFilter(filter) {
		const filterExists = filterArray.value.some(f => f.property === filter.property && f.filter === filter.filter);
		if (!filterExists) {
			filterArray.value.push(filter);
		}
	}

	function filterTaskList(array, property, filter) {
		return array.filter((task) => task[property] === filter);
	}

	addTask(1, 1);
	addTask(2, 2);
	addTask(3, 3);
	addTask(4, 4);
	addTask(5, 5);

	return {taskList, addTask, filteredTaskArray, addFilter,};
});