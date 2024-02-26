import {Person} from "./Directory.tsx";

export const PersonDirectory = ({personArray, setPersonArray}: { personArray: any, setPersonArray: any }) => {
	// const [personArray, setPersonArray] = useState<Person[]>([
	//     {firstName: "Edalyn", lastName: 'Clawthorne'},
	//     {firstName: "Raine", lastName: 'Whispers'},
	//     {firstName: "Luz", lastName: 'Noceda'}
	// ])

	return (
		<table className="table table-striped table-dark">
			<thead>
				<tr>
					<th>#</th>
					<th>First name</th>
					<th>Last name</th>
				</tr>
			</thead>
			<tbody>
				{personArray.map((person: Person, index: number) => (
					<tr key={index}>
						<td>{index + 1}</td>
						<td>{person.firstName}</td>
						<td>{person.lastName}</td>
					</tr>
				))}
			</tbody>
		</table>
	)
};