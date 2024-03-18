import React from 'react';
import Meal from "./classes/meal";
import {Image, StyleSheet, Text, TouchableOpacity, View} from "react-native";
import {GlobalStyles} from "./globalStyles.ts";
import {NavigationProp, useNavigation} from "@react-navigation/native";
import {RootStackParamList} from "./RecipeApp.tsx";

type Props = {
	meal: Meal;
}

export const MealCard: React.FC<Props> = (props) => {
	const navigation = useNavigation<NavigationProp<RootStackParamList>>();
	const openMealDetails = () => {
		navigation.navigate('MealDetails', {
			meal: props.meal,
		});
	}

	return (
		<TouchableOpacity onPress={openMealDetails}>
			<View style={[styles.view, GlobalStyles.centeredView]}>
				<Image
					source={{uri: props.meal.imageUrl}}
					style={{width: '100%', height: 250}}
				/>
				<Text style={GlobalStyles.title}>{props.meal.title}</Text>

				<View style={{flexDirection: 'row'}}>
					<Text style={{paddingHorizontal: 10}}>{props.meal.duration}m</Text>
					<Text style={{paddingHorizontal: 10}}>{props.meal.complexity}</Text>
					<Text style={{paddingHorizontal: 10}}>{props.meal.affordability}</Text>
				</View>
			</View>
		</TouchableOpacity>
	);
}

const styles = StyleSheet.create({
	view: {
		borderRadius: 10,
		backgroundColor: 'white',
		elevation: 5,
		padding: 10,
		margin: 10,
	},
});
