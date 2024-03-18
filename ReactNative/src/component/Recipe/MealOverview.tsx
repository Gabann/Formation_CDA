import React from 'react';
import {MEALS} from "./data/data";
import {FlatList, View} from "react-native";
import {MealCard} from "./MealCard.tsx";
import {useRoute} from "@react-navigation/native";

const mealsList = MEALS;

type RouteParams = {
	categoryId: number;
};

export const MealOverview: React.FC = () => {
	const route = useRoute();
	const {categoryId} = route.params as RouteParams;

	let meals = mealsList.filter(meal => meal.categoryIds.includes(categoryId));

	return (
		<View>
			<FlatList
				data={meals}
				renderItem={({item}) => (
					<MealCard meal={item}/>
				)}
				keyExtractor={(item) => item.id}
			/>
		</View>
	);
}
