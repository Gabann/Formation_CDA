import {useContext, useRef} from "react";
import {Contact, ExerciceContext} from "./ContextExercice.tsx";


export function AddItem() {
    let contactList: Contact[] = useContext(ExerciceContext)?.contactList ?? [];
    let setContactList = useContext(ExerciceContext)?.setContactList;

    console.log(contactList)
    console.log(setContactList)

    function addPerson() {
        let newContact: Contact = {
            firstName: firstName.current?.value ?? "",
            lastName: lastName.current?.value ?? ""
        };

        setContactList([...contactList, newContact]);
    }

    let firstName = useRef<HTMLInputElement>(null);
    let lastName = useRef<HTMLInputElement>(null);

    return (
        <>
            <input type="text" name="" id="" ref={firstName}/>
            <input type="text" name="" id="" ref={lastName}/>
            <button onClick={addPerson}>Add</button>
        </>
    );
}