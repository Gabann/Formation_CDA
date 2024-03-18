import React from 'react';
import {StyleSheet, Text, TouchableOpacity} from "react-native";
import Category from "./classes/category";
import {NavigationProp, useNavigation} from "@react-navigation/native";
import {RootStackParamList} from "./RecipeApp.tsx";

type Props = {
	category: Category;
}

export const CategoryButton: React.FC<Props> = ({category}) => {
	const navigation = useNavigation<NavigationProp<RootStackParamList>>();

	const openMealCategory = () => {
		navigation.navigate('MealOverview', {
			categoryId: category.id,
		});
	}

	const buttonStyle = {
		...styles.button,
		backgroundColor: category.color,
	};

	return (
		<TouchableOpacity style={buttonStyle}
		                  onPress={openMealCategory}>
			<Text style={styles.buttonText}>{category.title}</Text>
		</TouchableOpacity>
	);
}

const styles = StyleSheet.create({
	button: {
		borderRadius: 5,
		alignItems: 'center',
		justifyContent: 'center',
		margin: 10,
		width: '45%',
		height: 195,
	},
	buttonText: {
		color: '#000000',
		fontSize: 25,
		textAlign: 'center',
		textAlignVertical: 'center',
	}
})
