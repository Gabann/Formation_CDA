import {Board} from "./Board.tsx";
import './TicTacToe.css';
import React, {useMemo, useState} from "react";

interface IWinCondition {
	combo: number[];
	strike: string;

}

// const winConditions: number[][] = [
// 	[0, 1, 2],
// 	[3, 4, 5],
// 	[6, 7, 8],
// 	[0, 3, 6],
// 	[1, 4, 7],
// 	[2, 5, 8],
// 	[0, 4, 8],
// 	[2, 4, 6]
// ];

const winCondition: IWinCondition[] = [
	{combo: [0, 1, 2], strike: 'horizontal'},
	{combo: [3, 4, 5], strike: 'horizontal'},
	{combo: [6, 7, 8], strike: 'horizontal'},
	{combo: [0, 3, 6], strike: 'vertical'},
	{combo: [1, 4, 7], strike: 'vertical'},
	{combo: [2, 5, 8], strike: 'vertical'},
	{combo: [0, 4, 8], strike: 'diagonal'},
	{combo: [2, 4, 6], strike: 'diagonal'}
];


interface IGameContext {
	isXPlayerTurn: boolean,
	setIsXPlayerTurn: any,
	squareArray: string[];
	checkForWinner: () => string;
	resetGame: () => void;
}

export const GameContext = React.createContext<IGameContext | null>(null);

export function TicTacToe() {
	const [isXPlayerTurn, setIsXPlayerTurn] = useState<boolean>(true)
	const [squareArray, setSquareArray] = useState<string[]>([])

	const providerValue: IGameContext = useMemo(() => ({
		isXPlayerTurn,
		setIsXPlayerTurn,
		squareArray,
		checkForWinner,
		resetGame
	}), [isXPlayerTurn, squareArray]);

	function checkForWinner(): string {
		for (const condition of winCondition) {
			const [a, b, c]: number[] = condition.combo

			if (squareArray[a] && squareArray[a] === squareArray[b] && squareArray[b] === squareArray[c]) {
				return `Winner: ${squareArray[a]}`;
			}
		}

		//Return tie if the board is full and there is no winner
		if (squareArray.length === 9) {
			for (let i = 0; i < 9; i++) {
				if (!squareArray[i]) {
					return "";
				} else if (i === 8) {
					return "Tie";
				}
			}
		}

		return "";
	}

	function resetGame(): void {
		setSquareArray([]);
		setIsXPlayerTurn(true);
	}

	return (
		<GameContext.Provider value={providerValue}>
			<Board></Board>
		</GameContext.Provider>
	);
}