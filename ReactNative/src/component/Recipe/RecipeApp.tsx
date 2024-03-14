import React, {Component} from "react";
import {createNativeStackNavigator} from "@react-navigation/native-stack";
import {NavigationContainer} from "@react-navigation/native";
import {CategoryList} from "./CategoryList.tsx";
import {MealOverview} from "./MealOverview.tsx";
import {MealDetails} from "./MealDetails.tsx";

const Stack = createNativeStackNavigator();

export class RecipeApp extends Component {
	render() {

		return (
			<NavigationContainer>
				<Stack.Navigator>
					{/*// @ts-ignore*/}
					<Stack.Screen name="CategoryList" component={CategoryList}/>
					{/*// @ts-ignore*/}
					<Stack.Screen name="MealOverview" component={MealOverview}/>
					{/*// @ts-ignore*/}
					<Stack.Screen name="MealDetails" component={MealDetails}/>
				</Stack.Navigator>
			</NavigationContainer>
		);
	}
}
