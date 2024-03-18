import React from "react";
import {createNativeStackNavigator} from "@react-navigation/native-stack";
import {NavigationContainer} from "@react-navigation/native";
import {CategoryList} from "./CategoryList.tsx";
import {MealOverview} from "./MealOverview.tsx";
import {MealDetails} from "./MealDetails.tsx";
import Meal from "./classes/meal";

const Stack = createNativeStackNavigator();

export type RootStackParamList = {
	MealOverview: { categoryId: string };
	MealDetails: { meal: Meal };
};

export const RecipeApp: React.FC = () => {
	return (
		<NavigationContainer>
			<Stack.Navigator>
				<Stack.Screen name="CategoryList" component={CategoryList} options={{title: 'Meals category'}}/>
				<Stack.Screen name="MealOverview" component={MealOverview} options={{title: 'Meals overview'}}/>
				<Stack.Screen name="MealDetails" component={MealDetails} options={{title: 'Meal details'}}/>
			</Stack.Navigator>
		</NavigationContainer>
	);
}
