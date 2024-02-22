// import {ITask} from "../../App.tsx";
//
// export function Task({task, setTaskList}: Readonly<{ task: ITask, setTaskList: any }>) {
//     let day = task.deadline.getDate();
//     let month = task.deadline.getMonth() + 1;
//     let year = task.deadline.getFullYear();
//
//     const setTaskIsDone = (boolStatus: boolean) => {
//         setTaskList((taskList: ITask[]) => taskList.map((itteratedTask) => {
//             if (itteratedTask === task) {
//                 itteratedTask.isDone = boolStatus;
//             }
//
//             console.log(itteratedTask);
//             return itteratedTask;
//         }));
//     };
//
//     const deleteTask = () => {
//         setTaskList((taskList: ITask[]) => taskList.filter((t) => t !== task));
//     };
//
//
//     return (
//         <div className='border border-primary mb-4 p-2'>
//             <div className='row'>
//                 <div className='col-6'>
//                     <h2 className="display-4">{task.title}</h2>
//                 </div>
//                 <div className='col-6 d-flex align-items-center justify-content-end' style={{textAlign: "right"}}>
//                     <span className="text-muted">{`${day}/${month}/${year}`}</span>
//                 </div>
//             </div>
//
//             <hr/>
//
//             <p className="lead">{task.description}</p>
//
//             <div className='row'>
//                 <div className='col-6'>
//                     <button className="btn btn-primary" onClick={() => {
//                         setTaskIsDone(!task.isDone)
//                     }}>{task.isDone ? 'True' : 'False'}</button>
//                 </div>
//
//                 <div className='col-6  d-flex align-items-center justify-content-end'>
//                     <button className="btn btn-danger" onClick={deleteTask}>Delete</button>
//                 </div>
//             </div>
//         </div>
//     )
// }