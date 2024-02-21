import {useRef} from "react";

export function LogForm({onFormSubmit}: any) {
    let usernameRef = useRef<HTMLInputElement>(null);
    let passwordRef = useRef<HTMLInputElement>(null)

    return (
        <>
            <input type="text" ref={usernameRef}/>
            <input type="password" ref={passwordRef}/>
            <button onClick={() => onFormSubmit(usernameRef.current?.value, passwordRef.current?.value)}>Valider</button>
        </>
    );
}