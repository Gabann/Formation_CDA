import {Component} from "react";
import {MEALS} from "./data/data";
import {FlatList, StyleSheet, View} from "react-native";
import {MealCard} from "./MealCard.tsx";
import {NavigationProp} from "@react-navigation/native";

const mealsList = MEALS;

type Props = {
	navigation: NavigationProp<any, any>;
}

export class MealOverview extends Component<Props> {
	render() {
		// @ts-ignore
		let id: number = this.props.route.params.categoryId;

		let meals = mealsList.filter(meal => meal.categoryIds.includes(id));

		return (
			<View style={styles.view}>
				<FlatList
					data={meals}
					renderItem={({item}) => (
						<MealCard meal={item} navigation={this.props.navigation}/>
					)}
					keyExtractor={(item) => item.id}
				/>
			</View>
		);
	}
}

const styles = StyleSheet.create({
	view: {
		flex: 1,
	},
});
