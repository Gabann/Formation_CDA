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
import {Outlet} from "react-router-dom";
import React from "react";
import {HeaderComponent} from "./components/HeaderComponent.tsx";
import {FooterComponent} from "./components/FooterComponent.tsx";

function App() {
	return (
		<div>
			<div className='container'>
				<HeaderComponent/>

				<Outlet/>

				<FooterComponent/>
			</div>
		</div>
	);
}

export default App