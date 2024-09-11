import axios from 'axios';
import asyncStorage from '@react-native-async-storage/async-storage/src/AsyncStorage';
import {jwtDecode, JwtPayload} from 'jwt-decode';

const apiBaseUrl: string = 'http://10.0.2.2:3605/api/users/';

export async function tryLogIn(credentials: { email: string, password: string }): Promise<string> {
    await axios.post(apiBaseUrl + 'login', credentials, {
        headers: {
            'Content-Type': 'application/json',
        },
    })
        .then((response) => {
            asyncStorage.setItem('jwt', response.data);
            return response.data;
        })
        .catch((error) => {
            console.error(error);
            throw error;
        });

    return '';
}

export async function trySignUp(credentials: { email: string, password: string }): Promise<string> {
    await axios.post(apiBaseUrl + 'add', credentials, {
        headers: {
            'Content-Type': 'application/json',
        },
    })
        .then((response) => {
            console.log(response.data);
            return response.data;
        })
        .catch((error) => {
            console.error(error);
            throw error;
        });

    return '';
}

export async function logOut(): Promise<void> {
    try {
        await asyncStorage.removeItem('jwt');
    } catch (error) {
        console.error(error);
        throw error;
    }
}

export async function checkLogStatus(): Promise<boolean> {
    try {
        const token = await asyncStorage.getItem('jwt');

        if (token === null) {
            return false;
        }

        const decoded = jwtDecode<JwtPayload>(token);

        const currentTime = Date.now() / 1000;

        if (typeof decoded.exp === 'undefined' || decoded.exp < currentTime) {
            await asyncStorage.removeItem('jwt');
            return false;
        }

        console.log(decoded);
        return true;

    } catch (error) {
        console.error('Invalid token:', error);
        await asyncStorage.removeItem('jwt');
        return false;
    }
}
