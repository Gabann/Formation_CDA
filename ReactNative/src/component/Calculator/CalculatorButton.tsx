import {Component} from "react";
import {Pressable, StyleSheet, Text} from "react-native";

type StyleKeys = 'grey' | 'light';

type Props = {
	text: string;
	style: StyleKeys;
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
		const buttonStyle = [styles.button, styles[this.props.style]];
		if (this.state.isPressed) {
			buttonStyle.push(styles.buttonPressed);
		}

		return (
			<Pressable
				onPress={this.props.action}
				onPressIn={this.handlePressIn}
				onPressOut={this.handlePressOut}
				style={buttonStyle}
			>
				<Text style={{fontSize: 30}}>{this.props.text}</Text>
			</Pressable>
		);
	}
}

const styles = StyleSheet.create({
	button: {
		alignItems: 'center',
		justifyContent: 'center',
		width: 95,
		height: 95,
		margin: 5,
	},
	buttonPressed: {
		backgroundColor: 'pink',
		borderRadius: 30,
	},
	grey: {
		backgroundColor: 'grey',
		borderRadius: 30,
	},
	light: {
		backgroundColor: 'white',
		borderRadius: 50,
	},
});
