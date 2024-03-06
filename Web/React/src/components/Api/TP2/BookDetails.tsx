import {useContext, useEffect, useState} from "react";
import {ApiContext, IBook} from "./Api.tsx";
import {useParams} from "react-router-dom";
import axios from "axios";

export function BookDetails() {
	const {id} = useParams<{ id: string }>();
	let apiContext = useContext(ApiContext);

	let [bookList, setBookList] = useState<IBook[]>([]);

	async function getBookDescription(url: string): Promise<string> {
		try {
			const response = await axios.get(`https://openlibrary.org${url}.json`);
			return response.data.description;
		} catch (error) {
			console.error(error);
			return '';
		}
	}

	useEffect(() => {
		axios.get("https://openlibrary.org/subjects/science_fiction.json?limit=100")
			.then(async (response) => {
				const bookListPromises: Promise<IBook>[] = response.data.works.map(async (book: any) => {
					const description = await getBookDescription(book.key);
					return {
						title: book.title,
						coverUrlId: book.cover_id,
						authors: book.authors,
						publishingDate: book.first_publish_year,
						description: description
					};
				});

				const bookList = await Promise.all(bookListPromises);
				setBookList(bookList);
			})
			.catch(error => console.error(error));
	}, []);

	// let book: IBook = apiContext?.bookList[id]

	return (
		<div className="card">
			<div className="col-12">
				{/*<img src={`https://covers.openlibrary.org/b/id/${apiContext?.bookList[id].coverUrlId}-S.jpg`} className="card-img-top"/>*/}
			</div>
			<div className="row">
				<div className="col-4">
					<p>Titre: {apiContext?.bookList[id].title}</p>
					<p>Auteur:{id}</p>
					<p>Date publication:</p>
					<p>Description:</p>
				</div>

				{/*<div className="col-8">*/}
				{/*	<h3 className="card-title">{country?.name}</h3>*/}
				{/*	<p className="card-text">Capital: {country?.capital}</p>*/}
				{/*	<p className="card-text">Region: {country?.region}</p>*/}
				{/*	<p className="card-text">Population: {country?.population}</p>*/}
				{/*</div>*/}

			</div>
		</div>
	);
}