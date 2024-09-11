import React, {useState} from 'react';
import {Button, Text, TextInput, TouchableOpacity, View} from 'react-native';
import {useNavigation} from 'expo-router';
import {NavigationProp} from '@react-navigation/core';
import {RootStackParamList} from '@/app';
import formStyle from '@/src/assets/styles/formStyle';
import {checkLogStatus, logOut, tryLogIn, trySignUp} from '@/src/store/auth';

interface AuthComponentProps {
    isLogin: boolean;
}

const AuthComponent: React.FC<AuthComponentProps> = ({isLogin}) => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const navigation = useNavigation<NavigationProp<RootStackParamList>>();

    const handleAuth = () => {
        if (isLogin) {
            tryLogIn({email, password});
        } else {
            trySignUp({email, password});
        }
    };

    const handleRedirect = () => {
        if (isLogin) {
            navigation.navigate('SignupComponent');
        } else {
            navigation.navigate('LoginComponent');
        }
    };

    return (
        <View style={formStyle.container}>
            <Text style={formStyle.title}>{isLogin ? 'Log in' : 'Sign up'}</Text>

            <Text style={formStyle.label}>Email</Text>
            <TextInput
                style={formStyle.input}
                value={email}
                onChangeText={setEmail}
                placeholder="Enter your email"
                keyboardType="email-address"
                autoCapitalize="none"
            />
            <Text style={formStyle.label}>Password</Text>
            <TextInput
                style={formStyle.input}
                value={password}
                onChangeText={setPassword}
                placeholder="Enter your password"
                secureTextEntry
            />
            <Button title={isLogin ? 'Login' : 'Sign Up'} onPress={handleAuth}/>

            <Button title={'check log status'} onPress={checkLogStatus}/>

            <Button title={'log out'} onPress={logOut}/>

            <TouchableOpacity onPress={handleRedirect}>
                <Text style={formStyle.linkText}>
                    {isLogin ? 'You don\'t have an account yet? Click here to create one!' : 'You already have an account? Log in with it instead'}
                </Text>
            </TouchableOpacity>
        </View>
    );
};

export default AuthComponent;
