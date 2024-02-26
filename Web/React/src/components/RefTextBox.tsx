import {useState} from "react";

export const RefTextBox = () => {
	const [firstName, setFirstName] = useState<string>('First name');
	const [lastName, setLastName] = useState<string>('Last name');


	return (
		<div>
			<input value={firstName} onChange={e => setFirstName(e.target.value)}/>

			<input value={lastName} onChange={e => setLastName(e.target.value)}/>

			<span>Hello <strong>{firstName} {lastName.toUpperCase()}</strong>, welcome on the app</span>
		</div>
	);
};