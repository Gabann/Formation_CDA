import React, {useState} from 'react';
import {useNavigate} from 'react-router-dom';
import {todoService} from '../services/todoService';
import {userId} from '../shared/Header';

const CreateTodo = () => {
	const [todo, setTodo] = useState({
		title: '',
		description: '',
		status: '',
		userId: userId(),
	});
	const navigate = useNavigate();

	const handleChange = (e) => {
		const {name, value} = e.target;
		setTodo(prevState => ({
			...prevState,
			[name]: value,
		}));
	};

	const handleSubmit = async (e) => {
		e.preventDefault();
		try {
			await todoService.createTodo(todo);
			console.log('Todo created successfully');
			setTodo({title: '', status: '', description: ''});
		} catch (error) {
			console.error('Error creating todo:', error);
		}
	};

	return (
		<div className="container mt-5">
			<h2>Créer une nouvelle todo</h2>
			<form onSubmit={handleSubmit}>
				<div className="mb-3">
					<label htmlFor="todoTitle" className="form-label">Title</label>
					<input
						type="text"
						className="form-control"
						id="todoTitle"
						name="title"
						value={todo.title}
						onChange={handleChange}
					/>
				</div>
				<div className="mb-3">
					<label htmlFor="todoDescription" className="form-label">Description</label>
					<input
						type="text"
						className="form-control"
						id="todoDescription"
						name="description"
						value={todo.description}
						onChange={handleChange}
					/>
				</div>
				<div className="mb-3">
					<label htmlFor="todoStatus" className="form-label">Status</label>
					<select
						className="form-control"
						id="todoStatus"
						name="status"
						value={todo.status}
						onChange={handleChange}>
						<option value="PENDING">Pending</option>
						<option value="IN_PROGRESS">In progress</option>
						<option value="DONE">Done</option>
					</select>
				</div>
				<button type="submit" className="btn btn-primary">Créer</button>
			</form>
		</div>
	);
};

export default CreateTodo;
