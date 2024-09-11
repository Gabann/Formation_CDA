import React from 'react';
import {StyleSheet, View} from 'react-native';
import SignupComponent from '@/src/components/SignupComponent';

const SignupView = () => {
    return (
        <View style={styles.container}>
            <SignupComponent/>
        </View>
    );
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#F5FCFF',
    },
    text: {
        fontSize: 20,
        textAlign: 'center',
        margin: 10,
    },
});

export default SignupView;
