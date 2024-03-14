// ContactList.tsx
import {Component} from "react";
import {IContact} from "./ContactExercice.tsx";
import {FlatList} from "react-native";
import {Contact} from "./Contact.tsx";
import {NavigationProp} from '@react-navigation/native';

interface Props {
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
			<FlatList
				data={contactList}
				renderItem={({item}) => (
					<Contact contact={item} navigation={this.props.navigation}/>
				)}
				keyExtractor={(item) => item.phoneNumber.toString()}
			/>
		);
	}
}
