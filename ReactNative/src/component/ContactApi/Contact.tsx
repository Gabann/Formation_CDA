import React from 'react';
import {Pressable, StyleSheet, Text} from 'react-native';
import {IContact, RootStackParamList} from './ContactApi.tsx';
import {NavigationProp, useNavigation} from '@react-navigation/native';

type Props = {
	contact: IContact;
};

export function Contact({contact}: Readonly<Props>) {
	const navigation = useNavigation<NavigationProp<RootStackParamList>>();

	const openContactDetails = () => {
		navigation.navigate('ContactDetails', {
			contact: contact,
		});
	};

	return (
		<Pressable
			style={styles.button}
			onPress={openContactDetails}>
			<Text>
				{contact.firstName} {contact.lastName}
			</Text>
		</Pressable>
	);
}

const styles = StyleSheet.create({
	button: {
		backgroundColor: 'pink',
		padding: 10,
		borderRadius: 5,
		alignItems: 'center',
		margin: 10,
	},
});
