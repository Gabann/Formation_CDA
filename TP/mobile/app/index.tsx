import {createBottomTabNavigator} from '@react-navigation/bottom-tabs';
import {createNativeStackNavigator} from '@react-navigation/native-stack';
import Icon from 'react-native-vector-icons/MaterialCommunityIcons';
import AuthComponent from '@/src/components/AuthComponent';
import {ProductListView} from '@/src/screens/ProductListView';
import {store} from '@/src/store/store';
import {Provider} from 'react-redux';

const CollectionStack = createNativeStackNavigator();
const Tab = createBottomTabNavigator();

export type RootStackParamList = {
    SignupComponent: undefined;
    LoginComponent: undefined;
};

function AuthStackScreen() {
    return (
        <CollectionStack.Navigator>
            <CollectionStack.Screen
                name="LoginComponent"
                component={() => <AuthComponent isLogin={true}/>}
                options={{headerShown: false}}
            />
            <CollectionStack.Screen
                name="SignupComponent"
                component={() => <AuthComponent isLogin={false}/>}
                options={{headerShown: false}}
            />
        </CollectionStack.Navigator>
    );
}


function ProductStackScreen() {
    return (
        <CollectionStack.Navigator>
            <CollectionStack.Screen
                name="ProductList"
                component={() => <ProductListView/>}
                options={{headerShown: false}}
            />
        </CollectionStack.Navigator>
    );
}

export default function Index() {
    return (
        <Provider store={store}>
            <Tab.Navigator screenOptions={{
                tabBarActiveTintColor: 'orange',
                headerShown: false,
            }}>
                <Tab.Screen
                    name="Auth"
                    component={AuthStackScreen}
                    options={{
                        tabBarLabel: 'Auth',
                        tabBarIcon: ({color, size}) => (<Icon name="login" size={size} color={color}/>),
                    }}
                />
                <Tab.Screen
                    name="Tab 2"
                    component={ProductStackScreen}
                    options={{
                        tabBarLabel: 'Tab 2',
                        tabBarIcon: ({color, size}) => (<Icon name="shopping" size={size} color={color}/>),
                    }}
                />
            </Tab.Navigator>
        </Provider>
    );
}
