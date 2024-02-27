import {useEffect, useState} from "react";
import axios from "axios"

export function Api() {
	const [data, setData] = useState<any[]>([])

	useEffect(() => {
		axios.get("http://localhost:3000/personnes")
			.then((response) => {
				console.log(response);
				setData(response.data)
			}).catch(error => console.error(error))
	}, [])

	const addPerson = () => {
		axios.post("http://localhost:3000/personnes", {nom: "test"})
			.then((response) => {
				setData(prev => [...prev, response.data])
			}).catch((error) => {
			console.error(error);
		})
	}

	const deletePerson = () => {
		const id = 2

		axios.delete(`http://localhost:3000/personnes/${id}`)
			.then(() => console.log(`La personne avec l'id ${id} est correctement supprimée`))
			.catch((error) => {
				console.error(error);
			})
	}

	const updatePerson = () => {
		const id = 1

		axios.put(`http://localhost:3000/personnes/${id}`, {nom: "NouveauNom"})
			.then(response => console.log(response.data))
			.catch(error => console.error(error))
	}

	return (
		<>
			<button onClick={addPerson}>Ajout</button>
			<button onClick={deletePerson}>Supprimer</button>
			<button onClick={updatePerson}>Mettre à jour</button>
			{
				data && (
					<ul>
						{
							data.map((contact) => (
								<li key={contact.id}>{contact.nom}</li>
							))
						}
					</ul>
				)
			}
		</>
	)
}