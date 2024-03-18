import {Component} from "react";
import {StyleSheet, Text, View} from "react-native";

type Props = {
	text: string;
}

export class MiniCard extends Component<Props> {
	render() {
		return (
			<View style={styles.view}>
				<Text>{this.props.text}</Text>
			</View>
		);
	}
}

const styles = StyleSheet.create({
	view: {
		flex: 1,
		backgroundColor: '#e1b497',
		width: '80%',
		margin: 3,
		padding: 2,
		borderRadius: 8,
		justifyContent: 'center',
		alignItems: 'center',
	},
});
