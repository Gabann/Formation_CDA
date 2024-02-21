// import {useState} from "react";
// import {Person} from "../../App.tsx";
//
// export const DirectoryForm = ({personArray, setPersonArray}: { personArray: any, setPersonArray: any }) => {
//     const [firstName, setFirstName] = useState<string>('First name');
//     const [lastName, setLastName] = useState<string>('Last name');
//
//     function addPerson(): void {
//         if (firstName && lastName) {
//             let newPerson: Person = {firstName: firstName, lastName: lastName};
//             setPersonArray([...personArray, newPerson]);
//
//             setFirstName('')
//             setLastName('')
//         }
//     }
//    
//     return (
//         <>
//             <input value={firstName} onChange={e => setFirstName(e.target.value)}/>
//
//             <input value={lastName} onChange={e => setLastName(e.target.value)}/>
//
//             <button onClick={addPerson}>Add</button>
//         </>
//     );
// }