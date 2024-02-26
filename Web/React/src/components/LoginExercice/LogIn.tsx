import {LogForm} from "./LogForm.tsx";

export function LogIn() {
	let logIn = (username: string, password: string) => {
		console.log(`Username: ${username}, Password: ${password}`);
	}

	return (
		<div>
			<LogForm onFormSubmit={logIn}></LogForm>
		</div>
	);
}