import React, {useEffect, useState} from 'react';
import {todoService} from '../services/todoService';
import UpdateTodoModal from './UpdateTodoModal';
import {isAdmin} from '../shared/Header';


function TodoList() {
	const [todos, setTodos] = useState([]);
	const [error, setError] = useState('');

	useEffect(() => {
		todoService.getAllTodos()
			.then(response => {
				console.log(response);
				setTodos(response.data);
			})
			.catch(error => {
				setError('Erreur lors de la récupération des todo.');
			});
	}, []);

	const loadTodos = () => {
		todoService.getAllTodos()
			.then(response => {
				setTodos(response.data);
			})
			.catch(error => {
				setError('Erreur lors de la récupération des todo.');
			});
	};

	const [selectedTodo, setSelectedTodo] = useState(null);

	const updateTodo = (todoData) => {
		console.log('todo ' + todoData.title);
		todoService.updateTodo(todoData)
			.then(() => {
				loadTodos();
				setSelectedTodo(null);
			})
			.catch(error => {
				setError('Erreur lors de la mise à jour du todo.');
			});
	};


	const deleteTodo = (todoId) => {
		todoService.deleteTodo(todoId)
			.then(() => {
				loadTodos();
			})
			.catch(error => {
				setError('Erreur lors de la suppression du todo.');
			});
	};


	return (
		<div className="container mt-5">
			<h2>Todo List</h2>
			{error && <div className="alert alert-danger" role="alert">
				{error}
			</div>}
			<table className="table">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Title</th>
						<th scope="col">Description</th>
						<th scope="col">Status</th>
						<th scope="col">User</th>
						{isAdmin() === true && (
							<th scope="col" className="center">Actions</th>
						)}
					</tr>
				</thead>
				<tbody>
					{todos.map((todo, index) => (
						<tr key={todo.id}>
							<th scope="row">{index + 1}</th>
							<td>{todo.title}</td>
							<td>{todo.description}</td>
							<td>{todo.status}</td>
							<td>{todo.user?.username}</td>
							{isAdmin() === true && (
								<td>
									<button className="btn btn-danger mr-4" onClick={() => deleteTodo(todo.id)}>Supprimer</button>
									<button className="btn btn-warning" onClick={() => setSelectedTodo(todo)}>Update</button>
								</td>
							)}

						</tr>
					))}
					{selectedTodo && (
						<UpdateTodoModal
							todo={selectedTodo}
							onSave={updateTodo}
							onCancel={() => setSelectedTodo(null)}
						/>
					)}
				</tbody>
			</table>
		</div>
	);
}

export default TodoList;
