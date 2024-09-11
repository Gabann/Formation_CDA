import {StyleSheet} from 'react-native';

const formStyle = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        padding: 50,
        backgroundColor: '#F5FCFF',
    },
    title: {
        fontSize: 36,
        fontWeight: 'bold',
        marginBottom: 24,
        textAlign: 'center',
    },
    label: {
        fontSize: 16,
        marginBottom: 8,
    },
    input: {
        height: 40,
        borderColor: '#ccc',
        borderWidth: 1,
        marginBottom: 16,
        paddingHorizontal: 8,
    },
    linkText: {
        color: 'blue',
        marginTop: 16,
        textAlign: 'center',
    },
});

export default formStyle;
