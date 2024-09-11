import React, {useState} from 'react';
import {Button, Text, TextInput, TouchableOpacity, View} from 'react-native';
import {NavigationProp} from '@react-navigation/core';
import {useNavigation} from 'expo-router';
import {RootStackParamList} from '@/app';
import formStyle from '@/src/assets/styles/formStyle';
import {checkLogStatus, logOut, tryLogIn} from '@/src/store/auth';

const LoginComponent = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const navigation = useNavigation<NavigationProp<RootStackParamList>>();

    function handleLogin(): void {
        tryLogIn({email, password});
    }

    function handleSignUpRedirect(): void {
        navigation.navigate('SignupComponent');
    }

    return (
        <View style={formStyle.container}>
            <Text style={formStyle.title}>Log in</Text>

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
            <Button title="Login" onPress={handleLogin}/>

            <Button title={'check log status'} onPress={checkLogStatus}/>

            <Button title={'log out'} onPress={logOut}/>

            <TouchableOpacity onPress={handleSignUpRedirect}>
                <Text style={formStyle.linkText}>You don't have an account yet? Click here to create one!</Text>
            </TouchableOpacity>
        </View>
    );
};

export default LoginComponent;
