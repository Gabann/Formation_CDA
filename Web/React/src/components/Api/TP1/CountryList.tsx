import {ChangeEvent, useContext, useEffect, useRef, useState} from "react";
import {ApiContext} from "./Api.tsx";
import {CountryCard} from "./CountryCard.tsx";

export function CountryList() {
	let apiContext = useContext(ApiContext);

	let countrySearchRef = useRef<HTMLInputElement>(null);
	const [searchValue, setSearchValue] = useState('');

	useEffect(() => {
		apiContext?.setCountryListDisplay(
			apiContext.apiResults.filter((country) => {
				return (country.name.toLowerCase().includes(searchValue.toLowerCase()) || country.name.toLowerCase().startsWith(searchValue.toLowerCase()));
			}))
	}, [searchValue]);

	const handleInputChange = (event: ChangeEvent<HTMLInputElement>) => {
		setSearchValue(event.target.value);
	};

	return (
		<div className='d-flex flex-wrap'>

			<div className="col-12 mx-auto d-flex justify-content-center align-items-center">
				<input type="text" ref={countrySearchRef} onChange={handleInputChange}/>
			</div>

			{apiContext?.countryListDisplay.map((country, index: number) => {
					return (
						<div key={index} className="col-xl-3 col-md-4 col-sm-6 col-12 p-3">
							<CountryCard index={index}></CountryCard>
						</div>
					)
				}
			)}
		</div>
	);
}