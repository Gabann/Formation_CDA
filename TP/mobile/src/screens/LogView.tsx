import React from 'react';
import {StyleSheet, View} from 'react-native';
import LoginComponent from '@/src/components/LoginComponent';

const MyComponent = () => {
    return (
        <View style={styles.container}>
            <LoginComponent/>
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

export default MyComponent;
