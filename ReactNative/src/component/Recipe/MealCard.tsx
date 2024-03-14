import {Component} from "react";
import Meal from "./classes/meal";
import {Image, StyleSheet, Text, View} from "react-native";

type Props = {
	meal: Meal;
	navigation: any;
}

export class MealCard extends Component<Props> {
	render() {
		return (
			<View style={styles.view}>
				<Image
					source={{uri: this.props.meal.imageUrl}}
					style={{width: 200, height: 200}}
				/>
				<Text>{this.props.meal.title}</Text>
				<Text>{this.props.meal.duration}m</Text>
				<Text>{this.props.meal.complexity}</Text>
				<Text>{this.props.meal.affordability}</Text>
			</View>
		);
	}
}

const styles = StyleSheet.create({
	view: {
		flex: 1,
	},
});
