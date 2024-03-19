import {createNativeStackNavigator} from "@react-navigation/native-stack";
import {NavigationContainer} from "@react-navigation/native";
import {ContactList} from "./ContactList.tsx";
import React from "react";
import {ContactDetails} from "../ContactListNavigation/ContactDetails.tsx";

const Stack = createNativeStackNavigator();

export type RootStackParamList = {
	ContactList: undefined;
	ContactDetails: { contact: IContact };
};

export interface IContact {
	firstName: string;
	lastName: string;
	phoneNumber: number;
}

export function ContactApi() {
	return (
		<NavigationContainer>
			<Stack.Navigator>
				<Stack.Screen name="ContactList" component={ContactList} options={{headerShown: false}}/>
				<Stack.Screen name="ContactDetails" component={ContactDetails}/>
			</Stack.Navigator>
		</NavigationContainer>
	);
}
