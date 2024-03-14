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

// type RootStackParamList = {
// 	ContactList: undefined;
// 	ContactDetails: { contact: IContact };
// };

const Stack = createNativeStackNavigator();

export class ContactExercice extends Component {
	render() {
		return (
			<NavigationContainer>
				<Stack.Navigator>
					<Stack.Screen name="ContactList" component={ContactList}/>
					<Stack.Screen name="ContactDetails" component={ContactDetails}/>
				</Stack.Navigator>
			</NavigationContainer>
		);
	}
}
