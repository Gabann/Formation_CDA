import axios from "axios";
import React, {useEffect, useMemo, useState} from "react";
import {CountryList} from "./CountryList.tsx";

interface ICountry {
	name: string,
	capital: string,
	region: string,
	flagUrlLink: string,
	population: number
}

interface IApiContext {
	countryListDisplay: ICountry[]
	setCountryListDisplay: any
	apiResults: ICountry[]
}

export const ApiContext = React.createContext<IApiContext | null>(null);

export function Api() {
	let [apiResults, setApiResults] = useState<ICountry[]>([]);
	let [countryListDisplay, setCountryListDisplay] = useState<ICountry[]>([]);

	const providerValue: IApiContext = useMemo(() => ({
		apiResults,
		countryListDisplay,
		setCountryListDisplay
	}), [countryListDisplay, apiResults]);

	useEffect(() => {
		axios.get("https://restcountries.com/v3.1/all")
			.then((response) => {
				const newCountryList: ICountry[] = [];
				for (const country of response.data) {
					newCountryList.push({
						name: country.translations.fra.common,
						capital: country.capital?.[0] || "No capital",
						region: country.region,
						flagUrlLink: country.flags.png,
						population: country.population.toLocaleString('fr-FR')
					});
				}
				setApiResults(newCountryList)
			})
			.catch(error => console.error(error)).then(
			() => {
				setCountryListDisplay(apiResults)
			}
		);
	}, []);

	useEffect(() => {
		setCountryListDisplay(apiResults);
	}, [apiResults]);


	return (
		<ApiContext.Provider value={providerValue}>
			<CountryList></CountryList>
		</ApiContext.Provider>
	)
}