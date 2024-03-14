import {Component} from "react";
import {Pressable, StyleSheet, Text} from "react-native";
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
				style={styles.button}
				onPress={this.openContactDetails}>
				<Text>
					{this.props.contact.firstName} {this.props.contact.lastName}
				</Text>
			</Pressable>
		);
	}
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
