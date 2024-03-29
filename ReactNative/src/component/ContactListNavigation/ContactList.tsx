// ContactList.tsx
import {Component} from "react";
import {IContact} from "./ContactExercice.tsx";
import {FlatList, StyleSheet, Text} from "react-native";
import {Contact} from "./Contact.tsx";
import {NavigationProp} from '@react-navigation/native';

type Props = {
	navigation: NavigationProp<any, any>;
}

let contactList: IContact[] = [
	{
		firstName: "John",
		lastName: "Doe",
		phoneNumber: 1234567890,
	},
	{
		firstName: "Jane",
		lastName: "Doe",
		phoneNumber: 151617,
	},
	{
		firstName: "John",
		lastName: "Smith",
		phoneNumber: 88888888,
	},
	{
		firstName: "Jane",
		lastName: "Smith",
		phoneNumber: 987654321,
	},
];

export class ContactList extends Component<Props> {
	render() {
		return (
			<>
				<Text style={styles.title}>ContactList</Text>

				<FlatList
					data={contactList}
					renderItem={({item}) => (
						<Contact contact={item} navigation={this.props.navigation}/>
					)}
					keyExtractor={(item) => item.phoneNumber.toString()}
				/>
			</>
		);
	}
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
