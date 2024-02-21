import {useRef} from "react";

export function TodoForm({addTask}: Readonly<{ addTask: any }>) {
    let taskTitle = useRef<HTMLInputElement>(null);
    let taskDescription = useRef<HTMLInputElement>(null);
    let taskDeadline = useRef<HTMLInputElement>(null);

    setInterval(() => {
        console.log((taskTitle.current?.value && taskDeadline.current?.value && taskDescription.current?.value))
    }, 1000);

    return (
        <>
            <h1>TodoForm</h1>
            <hr/>

            <div className="form-group">
                <label htmlFor="task-title">Title:</label>
                <input className='form-control' id='task-title' type="text" ref={taskTitle}/>

                <label htmlFor="task-description">Description:</label>
                <input className='form-control' id='task-description' type="text" ref={taskDescription}/>

                <label htmlFor="task-deadline">Deadline:</label>
                <input className='form-control' id='task-deadline' type="date" ref={taskDeadline}/>

                <br/>

                <button className='form-control' onClick={() => {
                    addTask({
                        title: taskTitle.current?.value,
                        description: taskDescription.current?.value,
                        deadline: new Date(taskDeadline.current?.value ?? ''),
                        isDone: false
                    })
                }}>
                    Submit
                </button>
            </div>
        </>
    );
}