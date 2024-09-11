import React, {useState} from 'react';
import {Button, Text, TextInput, TouchableOpacity, View} from 'react-native';
import {useNavigation} from 'expo-router';
import {NavigationProp} from '@react-navigation/core';
import {RootStackParamList} from '@/app';
import formStyle from '@/src/assets/styles/formStyle';
import {trySignUp} from '@/src/store/auth';

const SignupComponent = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const navigation = useNavigation<NavigationProp<RootStackParamList>>();


    const handleSignup = () => {
        trySignUp({email, password});
    };

    function handleSignUpRedirect(): void {
        navigation.navigate('LoginComponent');
    }

    return (
        <View style={formStyle.container}>
            <Text style={formStyle.title}>Sign up</Text>

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
            <Button title="Sign Up" onPress={handleSignup}/>


            <TouchableOpacity onPress={handleSignUpRedirect}>
                <Text style={formStyle.linkText}>You already have an account? Log in with it instead</Text>
            </TouchableOpacity>
        </View>
    );
};

export default SignupComponent;
