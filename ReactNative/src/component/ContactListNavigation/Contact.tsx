import {Component} from "react";
import {Pressable, Text} from "react-native";
import {IContact} from "./ContactExercice.tsx";

type Props = {
	contact: IContact;
	navigation: any;
};

export class Contact extends Component<Props> {
	openContactDetails = () => {
		this.props.navigation.navigate('ContactDetails', {
			contact: this.props.contact,
		});
	}

	render() {
		return (
			<Pressable
				onPress={this.openContactDetails}>
				<Text>
					{this.props.contact.firstName} {this.props.contact.lastName}
				</Text>
			</Pressable>
		);
	}
}
