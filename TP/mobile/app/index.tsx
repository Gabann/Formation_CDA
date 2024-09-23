import {createBottomTabNavigator} from '@react-navigation/bottom-tabs';
import {createNativeStackNavigator} from '@react-navigation/native-stack';
import Icon from 'react-native-vector-icons/MaterialCommunityIcons';
import AuthComponent from '@/src/components/AuthComponent';
import {ProductListView} from '@/src/screens/ProductListView';
import {store} from '@/src/store/store';
import {Provider} from 'react-redux';
import {useEffect} from 'react';
import AsyncStorage from '@react-native-async-storage/async-storage';
import {AppState, AppStateStatus} from 'react-native';

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
                options={{headerShown: false}}
            >
                {() => <AuthComponent isLogin={true}/>}
            </CollectionStack.Screen>
            <CollectionStack.Screen
                name="SignupComponent"
                options={{headerShown: false}}
            >
                {() => <AuthComponent isLogin={false}/>}
            </CollectionStack.Screen>
        </CollectionStack.Navigator>
    );
}

function ProductStackScreen() {
    return (
        <CollectionStack.Navigator>
            <CollectionStack.Screen
                name="ProductList"
                options={{headerShown: false}}
            >
                {() => <ProductListView/>}
            </CollectionStack.Screen>
        </CollectionStack.Navigator>
    );
}

export default function Index() {

    useEffect(() => {
        const handleAppStateChange = async (nextAppState: AppStateStatus) => {
            if (nextAppState === 'background') {
                await AsyncStorage.removeItem('allProducts');
            }
        };
        const subscription = AppState.addEventListener('change', handleAppStateChange);

        return () => {
            subscription.remove();
        };
    }, []);

    return (
        <Provider store={store}>
            <Tab.Navigator screenOptions={{
                tabBarActiveTintColor: 'orange',
                headerShown: false,
            }}>
                <Tab.Screen
                    name="Shop"
                    component={ProductStackScreen}
                    options={{
                        tabBarLabel: 'Shop',
                        tabBarIcon: ({color, size}) => (<Icon name="shopping" size={size} color={color}/>),
                    }}
                />
                <Tab.Screen
                    name="Cart"
                    component={ProductStackScreen}
                    options={{
                        tabBarLabel: 'Cart',
                        tabBarIcon: ({color, size}) => (<Icon name="cart" size={size} color={color}/>),
                    }}
                />
                <Tab.Screen
                    name="Auth"
                    component={AuthStackScreen}
                    options={{
                        tabBarLabel: 'Auth',
                        tabBarIcon: ({color, size}) => (<Icon name="login" size={size} color={color}/>),
                    }}
                />
            </Tab.Navigator>
        </Provider>
    );
}
