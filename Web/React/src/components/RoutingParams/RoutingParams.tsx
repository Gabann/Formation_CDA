import {NavLink, useParams, useSearchParams} from "react-router-dom";
import {useState} from "react";

export interface Person {
	firstName: string;
	lastName: string;
}

export function RoutingParams() {
	const {id} = useParams()
	const [searchParams] = useSearchParams()

	const [contactArray, setContactArray] = useState<Person[]>([
		{
			firstName: "John",
			lastName: "Doe"
		},
		{
			firstName: "Jane",
			lastName: "Doe"
		},
	]);

	function removeContactById(id: number) {
		setContactArray(contactArray.filter((contact, index) => index !== id));
	}

	const [firstName, setFirstName] = useState<string>('First name');
	const [lastName, setLastName] = useState<string>('Last name');

	function addContact(): void {
		if (firstName && lastName) {
			let newPerson: Person = {firstName: firstName, lastName: lastName};
			setContactArray([...contactArray, newPerson]);

			setFirstName('')
			setLastName('')
		}
	}

	function editContactById(id: number) {

		const arrCopy = [...contactArray];
		const index = id;
		const value = {firstName: firstName, lastName: lastName};
		arrCopy[index] = value;

		setContactArray(arrCopy);
	}

	const mode = searchParams.get("mode") ?? "read"

	return (
		<div>
			<NavLink to={{pathname: `/RoutingParams/${id}`, search: "?mode=create"}}>
				<button>C</button>
			</NavLink>
			<NavLink to={{pathname: `/RoutingParams/${id}`, search: "?mode=read"}}>
				<button>R</button>
			</NavLink>

			<NavLink to={{pathname: `/RoutingParams/${id}`, search: "?mode=update"}}>
				<button>U</button>
			</NavLink>

			<NavLink to={{pathname: `/RoutingParams/${id}`, search: "?mode=delete"}}>
				<button>D</button>
			</NavLink>

			<br/>

			<table className="table table-striped table-dark">
				<thead>
					<tr>
						<th>#</th>
						<th>First name</th>
						<th>Last name</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					{contactArray.map((person: Person, index: number) => (
						<tr key={index}>
							<td>{index + 1}</td>
							<td>{person.firstName}</td>
							<td>{person.lastName}</td>
							<td>
								{mode === 'delete' &&
									<button onClick={() => {
										removeContactById(index)
									}}>
										Delete
									</button>
								}

								{mode === 'update' &&
									<button onClick={() => {

									}}>
										Update
									</button>
								}
							</td>
						</tr>
					))}
				</tbody>

			</table>

			{(mode === 'create' || mode === 'update') &&
				<div>
					<input value={firstName} onChange={e => setFirstName(e.target.value)}/>

					<input value={lastName} onChange={e => setLastName(e.target.value)}/>

					{mode === 'create' &&
						<button onClick={addContact}>Add</button>
					}


					{mode === 'update' && id &&
						<button onClick={() => {
							editContactById(parseInt(id))
						}}>Add</button>
					}

				</div>
			}
		</div>
	);
}