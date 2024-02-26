import {useState} from "react";
import {TodoForm} from "./TodoForm.tsx";
import {TaskList} from "./TaskList.tsx"

export interface ITask {
	title: string;
	description: string;
	deadline: Date;
	isDone: boolean;
}


export function TodoList() {
	const [taskList, setTaskList] = useState<ITask[]>([]);

	const addTask = (task: ITask): void => {
		setTaskList([...taskList, task]);
	}

	return (
		<div>
			<div className='container'>
				<div className='row'>
					<div className='col-6'><TodoForm addTask={addTask}/></div>
					<div className='col-6'><TaskList taskList={taskList} setTaskList={setTaskList}/></div>
				</div>
			</div>
		</div>
	);
}