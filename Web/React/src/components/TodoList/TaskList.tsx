import {Task} from "./Task.tsx";
import {ITask} from "./TodoList.tsx";

export function TaskList({taskList, setTaskList}: Readonly<{ taskList: ITask[], setTaskList: any }>) {
	return (
		<>
			<h1>TodoForm</h1>
			<hr/>

			{taskList.length > 0 ?
				(
					taskList.map((task, index) => (
						<div key={index}>
							<Task task={task} setTaskList={setTaskList}/>
						</div>
					))
				)
				: (
					<p>Task list is empty</p>
				)}
		</>
	);
}