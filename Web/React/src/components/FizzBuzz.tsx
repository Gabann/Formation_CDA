import {useState} from "react";

let maxValue: number = 100
let minValue: number = 0

interface Rule {
	number: number,
	word: string
}

let ruleset: Rule[] = [
	{number: 3, word: "Fizz"},
	{number: 5, word: "Buzz"},
	{number: 7, word: "Bizz"},
	{number: 22, word: "Fuzz"}
]

function getFizzBuzzResults(number: number): string {
	let result: string = ''

	for (const rule of ruleset) {
		if (number % rule.number === 0) {
			result += rule.word
		}
	}

	if (result === '') result = number.toString()

	return result;
}

export const FizzBuzz = () => {
	const [number, setNumber] = useState<number>(15)

	function changeNumberValue(targetValue: number): void {
		if (targetValue >= minValue && targetValue <= maxValue) {
			setNumber(targetValue);
		}
	}

	return (
		<div>
			<span>{getFizzBuzzResults(number)}</span>
			<br/>
			<button onClick={() => changeNumberValue(number - 1)} disabled={number === minValue}>-</button>
			{number}
			<button onClick={() => changeNumberValue(number + 1)} disabled={number === maxValue}>+</button>
		</div>
	);
};