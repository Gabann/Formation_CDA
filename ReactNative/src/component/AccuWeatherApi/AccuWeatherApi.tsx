import {Button, Text, View} from "react-native";
import {useEffect, useState} from "react";
import Geolocation from "@react-native-community/geolocation";
import {API_KEY} from "@env";

let apiBaseURL = 'http://dataservice.accuweather.com/locations/v1/';

interface ILocalisation {
	country: string;
	city: string;
}

interface GeoPosition {
	coords: {
		latitude: number;
		longitude: number;
	};
}

export function AccuWeatherApi() {
	const [latitude, setLatitude] = useState<number>()
	const [longitude, setLongitude] = useState<number>()
	const [localisation, setLocalisation] = useState<ILocalisation>({country: '', city: ''});

	function getLoc() {
		Geolocation.requestAuthorization(
			() => {
			},
			(error: string) => console.log('Authorization error: ', error)
		);
		Geolocation.getCurrentPosition((position: GeoPosition) => {
				setLatitude(position.coords.latitude)
				setLongitude(position.coords.longitude)
			},
			(error: string) => console.log(error),
			{enableHighAccuracy: true, timeout: 20000, maximumAge: 1000}
		)
	}

	async function getData() {
		getLoc();
		if (latitude && longitude) {

			try {
				await fetch(`${apiBaseURL}/cities/geoposition/search?apikey=${API_KEY}&q=${latitude}%2C%20${longitude}`)
					.then(response => response.json())
					.then((json): void => {
						setLocalisation({
							country: json.Country.LocalizedName,
							city: json.LocalizedName
						})
					});
			} catch (error) {
				console.error(error);
			}
		}
	}

	useEffect(() => {
		getData();
	}, [latitude, longitude])

	return (
		<View>
			<Text>Lat {latitude} Long {longitude}</Text>
			<Text>You are in {localisation.city} and {localisation.country}</Text>

			<Button onPress={() => getData()} title="Refresh"/>
		</View>
	)
}
