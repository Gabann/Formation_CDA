// import './global.css'
// import {LogForm} from "./components/LoginExercice/LogForm.tsx";
//
// // export interface Person {
// //     firstName: string;
// //     lastName: string;
// // }
//
// function App() {
//     // const [personArray, setPersonArray] = useState<Person[]>([]);
//
//     let logIn = (username: string, password: string) => {
//         console.log(`Username: ${username}, Password: ${password}`);
//     }
//
//     return (
//         <div>
//             <LogForm onFormSubmit={logIn}></LogForm>
//
//             {/*{personArray.length > 0 ?*/}
//             {/*    (*/}
//             {/*        <PersonDirectory personArray={personArray} setPersonArray={setPersonArray}/>*/}
//             {/*    )*/}
//             {/*    : (*/}
//             {/*        <p>Directory is empty</p>*/}
//             {/*    )}*/}
//
//             {/*<DirectoryForm personArray={personArray} setPersonArray={setPersonArray}/>*/}
//         </div>
//     )
// }
//
// export default App

import './global.css'
import {TodoForm} from "./components/TodoList/TodoForm.tsx";
import {TaskList} from "./components/TodoList/TaskList.tsx";
import {useState} from "react";

export interface ITask {
    title: string;
    description: string;
    deadline: Date;
    isDone: boolean;
}

function App() {
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

export default App