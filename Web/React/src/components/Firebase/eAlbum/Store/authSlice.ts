import {createSlice, PayloadAction} from '@reduxjs/toolkit';
import {createUserWithEmailAndPassword, signInWithEmailAndPassword} from "firebase/auth";
import {auth} from '../firebaseConfig.ts';

export interface Iuser {
	user: any,
	authMode: string
}

export interface Icredentials {
	email: string,
	password: string,
	returnSecureToken: boolean
}

const initialState: Iuser = {
	user: null,
	authMode: ''
};

const entitySlice = createSlice({
	name: 'auth',
	initialState,
	reducers: {
		logIn: (state, action: PayloadAction<Icredentials>) => {
			signInWithEmailAndPassword(auth, action.payload.email, action.payload.password)
				.then((userCredential) => {
					const user: any = userCredential.user;
					console.log(user.accessToken)
					localStorage.setItem("token", user.accessToken)

				})
				.catch((error) => {
					console.error(error.code)
					console.error(error.message)
				});
		},
		signUp: (state, action: PayloadAction<Icredentials>) => {
			createUserWithEmailAndPassword(auth, action.payload.email, action.payload.password)
				.then((userCredential) => {
					const user = userCredential.user;
					console.log(user)
				})
				.catch((error) => {
					console.error(error.code)
					console.error(error.message)
				});
		}
	},
});

export const {logIn, signUp} = entitySlice.actions;

export default entitySlice.reducer;