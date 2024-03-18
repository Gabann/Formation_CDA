import {Component} from "react";
import Meal from "./classes/meal";
import {Image, StyleSheet, Text, TouchableOpacity, View} from "react-native";

type Props = {
	meal: Meal;
	navigation: any;
}

export class MealCard extends Component<Props> {

	openMealDetails = () => {
		this.props.navigation.navigate('MealDetails', {
			meal: this.props.meal,
		});
	}

	render() {
		return (
			<TouchableOpacity onPress={this.openMealDetails}>
				<View style={styles.view}>
					<Image
						source={{uri: this.props.meal.imageUrl}}
						style={{width: '100%', height: 250}}
					/>
					<Text style={styles.title}>{this.props.meal.title}</Text>

					<View style={{flexDirection: 'row'}}>
						<Text style={{paddingHorizontal: 10}}>{this.props.meal.duration}m</Text>
						<Text style={{paddingHorizontal: 10}}>{this.props.meal.complexity}</Text>
						<Text style={{paddingHorizontal: 10}}>{this.props.meal.affordability}</Text>
					</View>
				</View>
			</TouchableOpacity>
		);
	}
}

const styles = StyleSheet.create({
	view: {
		flex: 1,
		borderRadius: 10,
		backgroundColor: 'white',
		elevation: 5,
		padding: 10,
		margin: 10,
		justifyContent: 'center',
		alignItems: 'center',
	},
	title: {
		fontSize: 20,
		fontWeight: 'bold',
		color: '#333',
		margin: 10,
	},
});
