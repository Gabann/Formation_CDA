import {useState} from "react";
import {PersonDirectory} from "./PersonDirectory.tsx";
import {DirectoryForm} from "./DirectoryForm.tsx";

export interface Person {
	firstName: string;
	lastName: string;
}


export function Directory() {

	const [personArray, setPersonArray] = useState<Person[]>([]);
	//
	// let logIn = (username: string, password: string) => {
	// 	console.log(`Username: ${username}, Password: ${password}`);
	// }

	return (
		<>
			{personArray.length > 0 ?
				(
					<PersonDirectory personArray={personArray} setPersonArray={setPersonArray}/>
				)
				: (
					<p>Directory is empty</p>
				)}

			<DirectoryForm personArray={personArray} setPersonArray={setPersonArray}/>
		</>
	);
}