import {Provider} from "react-redux";
import {store} from "./store/store";
import {NavigationContainer} from "@react-navigation/native";
import {createBottomTabNavigator} from '@react-navigation/bottom-tabs'
import MyId from "./MyId";
import Form from "./Form.tsx";
import Icon from 'react-native-vector-icons/FontAwesome'

const Tab = createBottomTabNavigator()

export function TestRedux() {
	return (
		<NavigationContainer>
			<Provider store={store}>
				<Tab.Navigator screenOptions={{
					tabBarActiveTintColor: "orange",
				}}>
					<Tab.Screen
						name='MyId'
						component={MyId}
						options={{
							tabBarIcon: ({color, size}) => <Icon name="home" size={size} color={color}/>,
							tabBarLabel: "MyId"
						}}
					/>
					<Tab.Screen
						name='Form'
						component={Form}
						options={{
							tabBarIcon: ({color, size}) => <Icon name="info" size={size} color={color}/>,
							tabBarLabel: "Form"
						}}
					/>
				</Tab.Navigator>
			</Provider>
		</NavigationContainer>
	);
}
