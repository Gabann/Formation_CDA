const redis = require("redis");

const readline = require('node:readline');
const {stdin: input, stdout: output} = require('node:process');
const rl = readline.createInterface({input, output});

const host = "127.0.0.1";
const port = "6379";
const client = redis.createClient(port, host);
client.connect();


const {Task} = require("./Task");
const taskListKey = "TaskList";

async function askQuestionReadline(question) {
	return new Promise((resolve) => {
		rl.question(question + "\n", (answer) => {
			resolve(answer);
		});
	});
}

async function addTask() {
	try {
		let taskTitle = await askQuestionReadline("Enter the task Title");
		let taskDescription = await askQuestionReadline("Enter the task description");

		let task = new Task(taskTitle, taskDescription);

		let taskList = await getStoredTaskList();
		taskList.push(task);

		await client.set(taskListKey, JSON.stringify(taskList));
	} catch (error) {
		console.error(error);
	}
}

async function removeTaskByTitle() {
	try {
		let title = await askQuestionReadline("Enter task title you'd like to remove");

		let taskList = await getStoredTaskList();

		taskList = taskList.filter(task => task.title !== title);

		await client.set(taskListKey, JSON.stringify(taskList));
	} catch (error) {
		console.error(error);
	}
}

async function viewTaskList() {
	try {
		let taskList = await getStoredTaskList();

		for (const task of taskList) {
			console.log(`Title :${task.title}`);
			console.log(`Description :${task.description}`);
			console.log("\n");
		}
	} catch (error) {
		console.error(error);
	}
}

async function getStoredTaskList() {
	try {
		let taskList = await client.get(taskListKey);
		taskList = taskList ? JSON.parse(taskList) : [];
		return taskList;
	} catch (error) {
		console.error(error);
	}
}

async function displayMenu() {
	try {
		let option = await askQuestionReadline(`Choose an option:
 1. Add a task
 2. View task list
 3. Delete a task`);

		if (option === '-1') {
			console.log("Quiting menu");
			rl.close();
			return;
		}

		switch (option) {
			case '1':
				await addTask();
				break;
			case '2':
				await viewTaskList();
				break;
			case '3':
				await removeTaskByTitle();
				break;
			default:
				console.log('Invalid option. Please choose 1, 2, or 3.');
		}

		displayMenu();

	} catch (error) {
		console.error(error);
	}
}

// client.on("connect", (err) => {
// 	console.mongodb.log(err);
// 	console.mongodb.log("connected");
// }).connect();

// (async () => {
// 	try {
// 		await client.set("key1", "value1");
// 		const value = await client.get("key1")
// 		console.mongodb.log(value);
// 	} catch (e) {
// 		console.mongodb.error(e);
// 	}
// })();

displayMenu();