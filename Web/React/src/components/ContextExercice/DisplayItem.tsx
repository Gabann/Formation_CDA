import {useContext} from "react";
import {ExerciceContext} from "./ContextExercice.tsx";

export function DisplayItem() {
    let contactList = useContext(ExerciceContext)?.contactList;

    return (
        <>
            {contactList?.map((contact, index) => (
                <div key={index}>
                    <p>First Name: {contact.firstName}</p>
                    <p>Last Name: {contact.lastName}</p>
                    <button onClick={() => console.log(`First Name: ${contact.firstName}, Last Name: ${contact.lastName}`)}>Log Contact
                    </button>
                </div>
            ))}
        </>
    );
}