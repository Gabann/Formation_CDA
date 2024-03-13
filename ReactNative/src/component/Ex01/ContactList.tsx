import {Component} from "react";
import {Image, StyleSheet, Text} from "react-native";

export class ContactList extends Component {
	render() {
		return (
			<>
				<Image
					style={styles.image}
					source={{uri: 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/30/React_Logo_SVG.svg/1200px-React_Logo_SVG.svg.png'}}
				/>
				<Text style={styles.text}>
					Nom: Noceda
				</Text>
				<Text style={styles.text}>
					Prenom: Luz
				</Text>
				<Text style={styles.text}>
					Telephone: 06 06 06 06 06 06
				</Text>
				<Text style={styles.text}>
					Adresse: Somewhere in the boiling isles
				</Text>
			</>
		);
	}
}


const styles = StyleSheet.create({
	image: {
		width: 110,
		height: 100,
	},
	text: {
		fontSize: 25,
	},
});
