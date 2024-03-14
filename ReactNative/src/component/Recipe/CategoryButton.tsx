import {Component} from "react";
import {Pressable, StyleSheet, Text} from "react-native";
import Category from "./classes/category";

type Props = {
	category: Category;
	navigation: any;
}

export class CategoryButton extends Component<Props> {
	openMealCategory = () => {
		console.log(`test: ${this.props}`)

		this.props.navigation.navigate('MealOverview', {
			categoryId: this.props.category.id,
		});
	}

	render() {
		const buttonStyle = {
			...styles.button,
			backgroundColor: this.props.category.color,
		};

		return (
			<Pressable style={buttonStyle}
			           onPress={this.openMealCategory}>
				<Text style={styles.buttonText}>{this.props.category.title}</Text>
			</Pressable>
		);
	}
}

const styles = StyleSheet.create({
	button: {
		padding: 10,
		borderRadius: 5,
		alignItems: 'center',
		margin: 10,
		width: '40%',
		height: 200,
	},
	buttonText: {
		color: '#000000',
		textAlign: 'center',
	}
})
