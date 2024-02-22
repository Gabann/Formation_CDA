import React, {useMemo, useState} from "react";
import {AddItem} from "./AddItem.tsx";
import {DisplayItem} from "./DisplayItem.tsx";

export interface Contact {
    firstName: string;
    lastName: string;
}

interface IExerciceContext {
    contactList: Contact[];
    setContactList: any;
}

export const ExerciceContext = React.createContext<IExerciceContext | undefined>(undefined);

export function ContextExercice() {
    const [contactList, setContactList] = useState<any>([]);
    const providerValue: IExerciceContext = useMemo(() => ({contactList, setContactList}), [setContactList, contactList]);
    
    return (
        <ExerciceContext.Provider value={providerValue}>
            <AddItem/>
            <DisplayItem/>
        </ExerciceContext.Provider>
    );
}