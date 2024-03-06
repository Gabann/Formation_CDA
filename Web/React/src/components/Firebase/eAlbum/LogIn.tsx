import {useRef} from "react";
import {useAppDispatch} from "../../Redux/hooks.ts";
import {Icredentials, signUp} from "./Store/authSlice.ts";

export function LogIn() {
	const dispatch = useAppDispatch();

	const emailRef = useRef<HTMLInputElement>(null);
	const passwordRef = useRef<HTMLInputElement>(null);

	function tryLogIn() {
		if (emailRef.current && passwordRef.current) {
			const credentials: Icredentials = {
				email: emailRef.current.value,
				password: passwordRef.current.value,
				returnSecureToken: true
			}
			dispatch(signUp(credentials))
		}
	}

	return (
		<>
			<label htmlFor='email'> Email </label>
			<input id='email' type='text' ref={emailRef} placeholder='Email' defaultValue='a@a.com'/>

			<label htmlFor='password'> Email </label>
			<input id='password' type='password' ref={passwordRef} placeholder='Password' defaultValue='aaaaaa'/>

			<button onClick={() => {
				tryLogIn()
			}}>Log in
			</button>
		</>
	);
}