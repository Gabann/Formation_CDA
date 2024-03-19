import React, {useState} from "react";
import {FlatList, StyleSheet, Text} from "react-native";
import {Contact} from "./Contact.tsx";
import {IContact} from "./ContactApi.tsx";

let apiBaseURL = 'https://jsonplaceholder.typicode.com';

interface IJsonResponse {
	name: string;
	phone: string;
}

function filterPhoneNumber(phoneNumber: string): number {
	phoneNumber = phoneNumber.split('x')[0];
	return parseInt(phoneNumber.replace(/[^0-9]/g, ''));
}

export function ContactList() {
	const [contactList, setContactList] = useState<IContact[]>();

	try {
		fetch(`${apiBaseURL}/users`)
			.then(response => response.json())
			.then((json: IJsonResponse[]) => {
				setContactList(json.map((item: IJsonResponse) => ({
					firstName: item.name.split(' ')[0],
					lastName: item.name.split(' ')[1],
					phoneNumber: filterPhoneNumber(item.phone)
				})));
			});
	} catch (error) {
		console.error(error);
	}

	return (
		<>
			<Text style={styles.title}>ContactList</Text>

			<FlatList
				data={contactList}
				renderItem={({item}) => (
					<Contact contact={item}/>
				)}
				keyExtractor={(item) => item.phoneNumber.toString()}
			/>
		</>
	);
}

const styles = StyleSheet.create({
	title: {
		fontSize: 24,
		fontWeight: 'bold',
		color: '#000000',
		textAlign: 'center',
		margin: 10,
	}
})
