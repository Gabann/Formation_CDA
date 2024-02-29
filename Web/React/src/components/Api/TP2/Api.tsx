import axios from "axios";
import React, {useEffect, useMemo, useState} from "react";
import {BookList} from "./BookList.tsx";

export interface IBook {
	title: string,
	coverUrlId: string,
	authors: string[],
	publishingDate: string,
	description: string
}

interface IApiContext {
	bookList: IBook[]
}

export const ApiContext = React.createContext<IApiContext | null>(null);

export function Api() {
	let [bookList, setBookList] = useState<IBook[]>([]);

	const providerValue: IApiContext = useMemo(() => ({
		bookList,
	}), [bookList]);

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

	return (
		<ApiContext.Provider value={providerValue}>
			<BookList></BookList>
		</ApiContext.Provider>
	)
}