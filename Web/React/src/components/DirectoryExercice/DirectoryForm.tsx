import {useState} from "react";
import {Person} from "./Directory.tsx";

const firstNames: string[] = ['Emma', 'Liam', 'Olivia', 'Noah', 'Ava', 'Isabella', 'Sophia', 'Jackson', 'Lucas', 'Aiden', 'Mia', 'Layla', 'Elijah', 'Oliver', 'Amelia', 'Harper', 'Evelyn', 'Liam', 'Benjamin', 'William', 'Grace', 'Nora', 'Riley', 'Zoe', 'Ethan', 'Avery', 'Levi', 'Lily', 'Jack', 'Ella', 'Lucy', 'Mila', 'Lillian', 'Logan', 'Hannah', 'Aria', 'Ezra', 'Scarlett', 'Matthew', 'Anna', 'Sofia', 'Chloe', 'Aubrey', 'Ellie', 'Nathan', 'Mason', 'Liam', 'Madison', 'Abigail'];

const lastNames: string[] = ['Smith', 'Johnson', 'Williams', 'Jones', 'Brown', 'Davis', 'Miller', 'Wilson', 'Moore', 'Taylor', 'Anderson', 'Thomas', 'Jackson', 'White', 'Harris', 'Martin', 'Thompson', 'Garcia', 'Martinez', 'Robinson', 'Clark', 'Rodriguez', 'Lewis', 'Lee', 'Walker', 'Hall', 'Allen', 'Young', 'Hernandez', 'King', 'Wright', 'Lopez', 'Hill', 'Scott', 'Green', 'Adams', 'Baker', 'Gonzalez', 'Nelson', 'Carter', 'Mitchell', 'Perez', 'Roberts'];

function GetRandomName(): any {
	let firstName: string = firstNames[Math.floor(Math.random() * firstNames.length)];
	let lastName: string = lastNames[Math.floor(Math.random() * lastNames.length)];

	return {firstName: firstName, lastName: lastName};
}


export const DirectoryForm = ({personArray, setPersonArray}: { personArray: any, setPersonArray: any }) => {
	const [firstName, setFirstName] = useState<string>('First name');
	const [lastName, setLastName] = useState<string>('Last name');

	function addPerson(): void {
		if (firstName && lastName) {
			let newPerson: Person = {firstName: firstName, lastName: lastName};
			setPersonArray([...personArray, newPerson]);

			setFirstName('')
			setLastName('')
		}
	}

	const addRandomPerson = () => {
		const newPerson = GetRandomName();
		console.log(personArray)
		setPersonArray([...personArray, newPerson]);
	};

	return (
		<>
			<input value={firstName} onChange={e => setFirstName(e.target.value)}/>

			<input value={lastName} onChange={e => setLastName(e.target.value)}/>

			<button onClick={addPerson}>Add</button>

			<button onClick={addRandomPerson}>Add random person</button>
		</>
	);
}