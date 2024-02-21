// // const firstNames: string[] = ['Emma', 'Liam', 'Olivia', 'Noah', 'Ava', 'Isabella', 'Sophia', 'Jackson', 'Lucas', 'Aiden', 'Mia', 'Layla', 'Elijah', 'Oliver', 'Amelia', 'Harper', 'Evelyn', 'Liam', 'Benjamin', 'William', 'Grace', 'Nora', 'Riley', 'Zoe', 'Ethan', 'Avery', 'Levi', 'Lily', 'Jack', 'Ella', 'Lucy', 'Mila', 'Lillian', 'Logan', 'Hannah', 'Aria', 'Ezra', 'Scarlett', 'Matthew', 'Anna', 'Sofia', 'Chloe', 'Aubrey', 'Ellie', 'Nathan', 'Mason', 'Liam', 'Madison', 'Abigail'];
// //
// // const lastNames: string[] = ['Smith', 'Johnson', 'Williams', 'Jones', 'Brown', 'Davis', 'Miller', 'Wilson', 'Moore', 'Taylor', 'Anderson', 'Thomas', 'Jackson', 'White', 'Harris', 'Martin', 'Thompson', 'Garcia', 'Martinez', 'Robinson', 'Clark', 'Rodriguez', 'Lewis', 'Lee', 'Walker', 'Hall', 'Allen', 'Young', 'Hernandez', 'King', 'Wright', 'Lopez', 'Hill', 'Scott', 'Green', 'Adams', 'Baker', 'Gonzalez', 'Nelson', 'Carter', 'Mitchell', 'Perez', 'Roberts'];
// //
// // function GetRandomName(): any {
// //     let firstName: string = firstNames[Math.floor(Math.random() * firstNames.length)];
// //     let lastName: string = lastNames[Math.floor(Math.random() * lastNames.length)];
// //
// //     return {firstName: firstName, lastName: lastName};
// // }
// import {Person} from "../../App.tsx";
//
// export const PersonDirectory = ({personArray, setPersonArray}: { personArray: any, setPersonArray: any }) => {
//     // const [personArray, setPersonArray] = useState<Person[]>([
//     //     {firstName: "Edalyn", lastName: 'Clawthorne'},
//     //     {firstName: "Raine", lastName: 'Whispers'},
//     //     {firstName: "Luz", lastName: 'Noceda'}
//     // ])
//
//     // const addRandomPerson = () => {
//     //     const newPerson = GetRandomName();
//     //     console.log(personArray)
//     //     setPersonArray([...personArray, newPerson]);
//     // };
//
//
//     return (
//         <>
//             <table className="table table-striped table-dark">
//                 <thead>
//                     <tr>
//                         <th>#</th>
//                         <th>First name</th>
//                         <th>Last name</th>
//                     </tr>
//                 </thead>
//                 <tbody>
//                     {personArray.map((person: Person, index: number) => (
//                         <tr key={index}>
//                             <td>{index + 1}</td>
//                             <td>{person.firstName}</td>
//                             <td>{person.lastName}</td>
//                         </tr>
//                     ))}
//                 </tbody>
//             </table>
//
//             {/*<button onClick={addRandomPerson}>Add random person*/}
//             {/*</button>*/}
//         </>
//     )
// };