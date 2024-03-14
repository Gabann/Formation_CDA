import {Component} from "react";
import {Button, Linking, Text} from "react-native";
import {IContact} from "./ContactExercice.tsx";

type Props = {
	contact: IContact
};

export class ContactDetails extends Component<Props> {
	render() {
		const contact: IContact = this.props.route.params.contact;

		return (
			<>
				<Text>
					First name: {contact.firstName}
				</Text>
				<Text>
					Last name: {contact.lastName}
				</Text>
				<Text>
					Phone number: {contact.phoneNumber}
				</Text>
				<Button
					title="Call"
					onPress={() => Linking.openURL(`tel:${contact.phoneNumber}`)}
				/>
			</>
		);
	}
}
