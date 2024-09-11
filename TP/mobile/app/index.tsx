import {createBottomTabNavigator} from '@react-navigation/bottom-tabs';
import {createNativeStackNavigator} from '@react-navigation/native-stack';
import Icon from 'react-native-vector-icons/MaterialCommunityIcons';
import LoginView from '@/src/screens/LogView';
import SignupComponent from '@/src/components/SignupComponent';

const CollectionStack = createNativeStackNavigator();
const Tab = createBottomTabNavigator();

export type RootStackParamList = {
    SignupComponent: undefined;
    LoginComponent: undefined;
};

function LogStackScreen() {
    return (
        <CollectionStack.Navigator>
            <CollectionStack.Screen
                name="LoginComponent"
                component={LoginView}
                options={{headerShown: false}}
            />
            <CollectionStack.Screen
                name="SignupComponent"
                component={SignupComponent}
                options={{headerShown: false}}
            />
        </CollectionStack.Navigator>
    );
}

export default function Index() {
    return (
        // <Provider store={store}>
        <Tab.Navigator screenOptions={{
            tabBarActiveTintColor: 'orange',
            headerShown: false,
        }}>
            <Tab.Screen
                name="Log"
                component={LogStackScreen}
                options={{
                    tabBarLabel: 'Log',
                    tabBarIcon: ({color, size}) => (<Icon name="login" size={size} color={color}/>),
                }}
            />
            <Tab.Screen
                name="Tab 2"
                component={SignupComponent}
                options={{
                    tabBarLabel: 'Tab 2',
                    tabBarIcon: ({color, size}) => (<Icon name="shopping" size={size} color={color}/>),
                }}
            />
        </Tab.Navigator>
        // </Provider>
    );
}
