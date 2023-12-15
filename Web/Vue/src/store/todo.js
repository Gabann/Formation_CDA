import {defineStore} from "pinia";
import {Task} from "@/components/TodoListStore/Task.js";
import {computed, ref} from "vue";

export const useTodoStore = defineStore('todoItem', () => {
	let taskList = ref([]);
	let filterArray = ref([]);

	function addTodo(title, description) {
		let todoTask = new Task(title, description, false, false);

		taskList.value.push(todoTask);
	}

	function removeTodoByTitle(title) {
		taskList.value = taskList.value.filter(task => task.title !== title);
	}

	function favoriteTodoTaskByTitle(title) {
		let targetTask = taskList.value.find(task => task.title === title);
		targetTask.isFavorite = !targetTask.isFavorite;
	}

	function doTodoTaskByTitle(title) {
		let targetTask = taskList.value.find(task => task.title === title);
		targetTask.isDone = !targetTask.isDone;
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


	addTodo(1, 1);
	addTodo(2, 2);
	addTodo(3, 3);
	addTodo(4, 4);
	addTodo(5, 5);

	return {taskList, addTodo, removeTodoByTitle, favoriteTodoTaskByTitle, filteredTaskArray, addFilter, doTodoTaskByTitle};
});