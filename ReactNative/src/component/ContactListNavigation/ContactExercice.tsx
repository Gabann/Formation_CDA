import React, {Component} from "react";
import {createNativeStackNavigator} from "@react-navigation/native-stack";
import {NavigationContainer} from "@react-navigation/native";
import {ContactList} from "./ContactList.tsx";
import {ContactDetails} from "./ContactDetails.tsx";

export interface IContact {
	firstName: string;
	lastName: string;
	phoneNumber: number;
}

const Stack = createNativeStackNavigator();

export class ContactExercice extends Component {
	render() {

		return (
			<NavigationContainer>
				<Stack.Navigator>
					{/*// @ts-ignore*/}
					<Stack.Screen name="ContactList" component={ContactList} options={{headerShown: false}}/>
					{/*// @ts-ignore*/}
					<Stack.Screen name="ContactDetails" component={ContactDetails}/>
				</Stack.Navigator>
			</NavigationContainer>
		);
	}
}
