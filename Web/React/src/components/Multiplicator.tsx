import {useEffect, useState} from "react";

export const Multiplicator = ({expectedResult}: any) => {

    const [multiplierA, setMultiplierA] = useState<number>(1);
    const [multiplierB, setMultiplierB] = useState<number>(1);
    const [result, setResult] = useState<string>('');

    useEffect(() => {
        if (multiplierA * multiplierB === expectedResult) {
            setResult(`${multiplierA} * ${multiplierB} = ${expectedResult}`)
        } else setResult(`${multiplierA} * ${multiplierB} is not equal to ${expectedResult}`)
    }, [multiplierA, multiplierB])

    const forceNumberInput = (event: React.ChangeEvent<HTMLInputElement>, setMultiplier: React.Dispatch<React.SetStateAction<number>>) => {
        const value = parseInt(event.target.value, 10);
        setMultiplier(isNaN(value) ? 0 : value);
    };

    return (
        <div>
            <input value={multiplierA} onChange={(event) => forceNumberInput(event, setMultiplierA)}/>

            <span>
                X
            </span>
            <input value={multiplierB} onChange={(event) => forceNumberInput(event, setMultiplierB)}/>
            <span>
                = {multiplierA * multiplierB}
            </span>

            <br/>
            {result}
        </div>
    );
};