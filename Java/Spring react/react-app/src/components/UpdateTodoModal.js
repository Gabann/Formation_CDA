import React, {useState} from 'react';

function UpdateTodoModal({todo, onSave, onCancel}) {
	const [title, setTitle] = useState(todo?.title);
	const [description, setDescription] = useState(todo?.description);
	const [status, setSatus] = useState(todo?.status);
	const handleSubmit = (e) => {
		e.preventDefault();
		onSave({id: todo.id, title, description, status});
	};

	return (
		<div className="modal" style={{display: 'block', backgroundColor: 'rgba(0,0,0,0.5)'}}>
			<div className="modal-dialog">
				<div className="modal-content">
					<div className="modal-header">
						<h5 className="modal-title">Update Todo</h5>
						<button type="button" className="close" onClick={onCancel}>
							<span>&times;</span>
						</button>
					</div>
					<div className="modal-body">
						<form onSubmit={handleSubmit}>
							<div className="form-group">
								<label>Title</label>
								<input type="text" className="form-control" value={title} onChange={(e) => setTitle(e.target.value)}/>
							</div>
							<div className="form-group">
								<label>Description</label>
								<textarea className="form-control" value={description}
								          onChange={(e) => setDescription(e.target.value)}/>
							</div>
							<div className="form-group">
								<label>Status</label>
								<select className="form-control" value={status} onChange={(e) => setSatus(e.target.value)}>
									<option value="PENDING">Pending</option>
									<option value="IN_PROGRESS">In progress</option>
									<option value="DONE">Done</option>
								</select>
							</div>
							<button type="submit" className="btn btn-primary">Save changes</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	);
}

export default UpdateTodoModal;
