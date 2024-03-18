import React from 'react';
import Meal from "./classes/meal";
import {FlatList, Image, ScrollView, StyleSheet, Text, View} from "react-native";
import {MiniCard} from "./MiniCard.tsx";
import {GlobalStyles, mainColor} from "./globalStyles.ts";
import {useRoute} from "@react-navigation/native";

type RouteParams = {
	meal: Meal;
};

export const MealDetails: React.FC = () => {
	const route = useRoute();
	const {meal} = route.params as RouteParams;

	return (
		<ScrollView contentContainerStyle={styles.view}>
			<Image
				source={{uri: meal.imageUrl}}
				style={{width: '100%', height: 400}}
			/>
			<Text style={GlobalStyles.title}>{meal.title}</Text>
			<View style={{flexDirection: 'row'}}>
				<Text style={{paddingHorizontal: 10}}>{meal.duration}m</Text>
				<Text style={{paddingHorizontal: 10}}>{meal.complexity.toUpperCase()}</Text>
				<Text style={{paddingHorizontal: 10}}>{meal.affordability.toUpperCase()}</Text>
			</View>

			<Text style={{color: mainColor, fontSize: 20}}>Ingredients</Text>
			<View style={styles.separator}/>

			<FlatList
				scrollEnabled={false}
				data={meal.ingredients}
				renderItem={({item}) => (
					<MiniCard text={item}/>
				)}
				keyExtractor={(item, index) => index.toString()}
			/>

			<Text style={{color: mainColor, fontSize: 20}}>Steps</Text>
			<View style={styles.separator}/>

			<FlatList
				scrollEnabled={false}
				data={meal.steps}
				renderItem={({item}) => (
					<MiniCard text={item}/>
				)}
				keyExtractor={(item, index) => index.toString()}
			/>
		</ScrollView>
	);
}

const styles = StyleSheet.create({
	view: {
		justifyContent: 'center',
		alignItems: 'center',
	},
	separator: {
		borderBottomColor: mainColor,
		borderBottomWidth: 2,
		marginVertical: 5,
		width: '80%',
	},
});
