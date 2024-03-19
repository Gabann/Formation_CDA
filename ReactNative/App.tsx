import {createNativeStackNavigator} from "@react-navigation/native-stack";
import {TestRedux} from "./src/component/Redux/TestRedux.tsx";

const Stack = createNativeStackNavigator();

export default function App() {
	return (
		// <NavigationContainer>
		// 	<Stack.Navigator
		// 		screenOptions={{headerShown: false}}>
		// 		<Stack.Screen name="Calculator" component={Calculator}/>
		// 		<Stack.Screen name="ContactList" component={ContactList}/>
		// 		<Stack.Screen name="List" component={List}/>
		// 	</Stack.Navigator>
		// </NavigationContainer>

		// <RecipeApp/>
		// <Async/>
		// <ContactApi/>
		<TestRedux/>
	)
}
