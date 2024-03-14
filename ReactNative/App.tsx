import React from 'react';
import {createNativeStackNavigator} from "@react-navigation/native-stack";
import {ContactExercice} from "./src/component/ContactListNavigation/ContactExercice.tsx";

const Stack = createNativeStackNavigator();

export default function App(): React.JSX.Element {
	return (
		// <NavigationContainer>
		// 	<Stack.Navigator
		// 		screenOptions={{headerShown: false}}>
		// 		<Stack.Screen name="Calculator" component={Calculator}/>
		// 		<Stack.Screen name="ContactList" component={ContactList}/>
		// 		<Stack.Screen name="List" component={List}/>
		// 	</Stack.Navigator>
		// </NavigationContainer>

		<ContactExercice/>
	)
}
