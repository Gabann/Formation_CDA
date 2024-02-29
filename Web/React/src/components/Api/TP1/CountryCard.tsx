import {useContext} from "react";
import {ApiContext} from "./Api.tsx";

export function CountryCard({index}: Readonly<{ index: number }>) {

	let apiContext = useContext(ApiContext);
	let country = apiContext?.countryListDisplay[index];

	return (
		<div className="card">
			<div className="col-12">
				<img src={country?.flagUrlLink} className="card-img-top" alt={country?.name}/>
			</div>
			<div className="row">
				<div className="col-4">
					<p>Nom pays:</p>
					<p>Capitale:</p>
					<p>Région:</p>
					<p>Nombre habitants:</p>
				</div>

				<div className="col-8">
					<h3 className="card-title">{country?.name}</h3>
					<p className="card-text">Capital: {country?.capital}</p>
					<p className="card-text">Region: {country?.region}</p>
					<p className="card-text">Population: {country?.population}</p>
				</div>

			</div>
		</div>
	);
}