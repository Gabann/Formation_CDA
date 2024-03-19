import React from 'react';
import {Linking, Pressable, StyleSheet, Text} from 'react-native';
import {useRoute} from '@react-navigation/native';
import {IContact} from "./ContactApi.tsx";

type RouteParams = {
	contact: IContact;
};

export function ContactDetails() {
	const route = useRoute();
	const {contact} = route.params as RouteParams;

	return (
		<>
			<Text style={styles.title}>
				First name: {contact.firstName}
			</Text>
			<Text style={styles.title}>
				Last name: {contact.lastName}
			</Text>
			<Text style={styles.title}>
				Phone number: {contact.phoneNumber}
			</Text>
			<Pressable
				style={styles.button}
				onPress={() => Linking.openURL(`tel:${contact.phoneNumber}`)}
			>
				<Text style={styles.buttonText}>Call</Text>
			</Pressable>
		</>
	);
}

const styles = StyleSheet.create({
	title: {
		fontSize: 20,
		color: '#000000',
		textAlign: 'center',
		margin: 10,
	},
	button: {
		padding: 10,
		borderRadius: 5,
		alignItems: 'center',
		marginTop: 10,
		width: '50%',
		alignSelf: 'center',
		backgroundColor: '#008000'
	},
	buttonText: {
		color: '#FFFFFF',
	}
})
