import api from './api';
import {authHeader} from '../helpers/auth-header';

const getAllTodos = () => {
	return api.get('/todo', {headers: authHeader()});
};


const createTodo = (todo) => {
	console.log(todo);
	return api.post('/todo/admin/post', {
		todo: {
			title: todo.title,
			description: todo.description,
			status: todo.status,
		},
		userId: todo.userId,
	}, {headers: authHeader()});
};


const deleteTodo = (todoId) => {
	return api.delete(`/todo/admin/${todoId}`, {headers: authHeader()});
};

const updateTodo = (todoData) => {
	console.log(todoData);
	return api.put('/todo/admin/update', todoData, {
		headers: {
			...authHeader(),
			'Content-Type': 'application/json',
		},
	});
};

export const todoService = {
	getAllTodos: getAllTodos,
	createTodo: createTodo,
	deleteTodo: deleteTodo,
	updateTodo: updateTodo,
};
