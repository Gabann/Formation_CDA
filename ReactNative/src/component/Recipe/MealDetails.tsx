import {Component} from "react";
import Meal from "./classes/meal";
import {FlatList, Image, StyleSheet, Text, View} from "react-native";
import {MiniCard} from "./MiniCard.tsx";

export class MealDetails extends Component {
	render() {
		// @ts-ignore
		let meal: Meal = this.props.route.params.meal;

		return (
			<View style={styles.view}>
				<Image
					source={{uri: meal.imageUrl}}
					style={{width: '100%', height: 400}}
				/>
				<Text style={styles.title}>{meal.title}</Text>
				<View style={{flexDirection: 'row'}}>
					<Text style={{paddingHorizontal: 10}}>{meal.duration}m</Text>
					<Text style={{paddingHorizontal: 10}}>{meal.complexity}</Text>
					<Text style={{paddingHorizontal: 10}}>{meal.affordability}</Text>
				</View>

				<Text>Ingredients</Text>
				<View style={styles.separator}/>

				<FlatList
					data={meal.ingredients}
					renderItem={({item}) => (
						<MiniCard text={item}/>
					)}
					keyExtractor={(item, index) => index.toString()}
				/>

				<Text>Steps</Text>
				<View style={styles.separator}/>

				<FlatList
					data={meal.steps}
					renderItem={({item}) => (
						<MiniCard text={item}/>
					)}
					keyExtractor={(item, index) => index.toString()}
				/>
			</View>
		);
	}
}

const styles = StyleSheet.create({
	view: {
		justifyContent: 'center',
		alignItems: 'center',
	},
	separator: {
		borderBottomColor: 'black',
		borderBottomWidth: 1,
		marginVertical: 10,
		width: '80%',
	},
	title: {
		fontSize: 24,
		fontWeight: 'bold',
		color: '#333',
	},
});
