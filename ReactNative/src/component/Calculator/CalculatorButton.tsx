import {Component} from "react";
import {Pressable, StyleSheet, Text} from "react-native";

type Props = {
	text: string;
	style: string;
	action: () => void;
};

type State = {
	isPressed: boolean;
};

export class CalculatorButton extends Component<Props, State> {
	state = {
		isPressed: false,
	};

	handlePressIn = () => {
		this.setState({isPressed: true});
	};

	handlePressOut = () => {
		this.setState({isPressed: false});
	};

	render() {
		const buttonStyle = this.state.isPressed ? styles.buttonPressed : styles.button;

		return (
			<Pressable
				onPress={this.props.action}
				onPressIn={this.handlePressIn}
				onPressOut={this.handlePressOut}
				style={[buttonStyle]}
			>
				<Text>{this.props.text}</Text>
			</Pressable>
		);
	}
}

const styles = StyleSheet.create({
	dark: {
		backgroundColor: 'grey',
	},
	light: {
		backgroundColor: 'white',
	},
	button: {
		alignItems: 'center',
		justifyContent: 'center',
		width: 100,
		height: 100,
		borderRadius: 50,
		backgroundColor: 'white',
	},
	buttonPressed: {
		alignItems: 'center',
		justifyContent: 'center',
		width: 100,
		height: 100,
		borderRadius: 50,
		backgroundColor: 'lightgrey',
	},
});
