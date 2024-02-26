import {Board} from "./Board.tsx";
import './TicTacToe.css';
import React, {useMemo, useRef, useState} from "react";

const winConditions: number[][] = [
	[0, 1, 2],
	[3, 4, 5],
	[6, 7, 8],
	[0, 3, 6],
	[1, 4, 7],
	[2, 5, 8],
	[0, 4, 8],
	[2, 4, 6]
];

interface IGameContext {
	isXPlayerTurn: boolean,
	setIsXPlayerTurn: any,
	squareArray: React.MutableRefObject<string[]>;
	checkForWinner: () => string;
}

export const GameContext = React.createContext<IGameContext | null>(null);

export function TicTacToe() {
	const [isXPlayerTurn, setIsXPlayerTurn] = useState<boolean>(true)
	const squareArray: React.MutableRefObject<string[]> = useRef([]);

	const providerValue: IGameContext = useMemo(() => ({isXPlayerTurn, setIsXPlayerTurn, squareArray, checkForWinner}), [isXPlayerTurn]);

	function checkForWinner(): string {
		for (const line of winConditions) {
			const [a, b, c]: number[] = line

			if (squareArray.current[a] && squareArray.current[a] === squareArray.current[b] && squareArray.current[b] === squareArray.current[c]) {
				return `Winner: ${squareArray.current[a]}`;
			}
		}

		//Return tie if the board is full and there is no winner
		if (squareArray.current.length === 9) {
			for (let i = 0; i < 9; i++) {
				if (!squareArray.current[i]) {
					return "";
				} else if (i === 8) {
					return "Tie";
				}
			}
		}

		return "";
	}


	return (
		<GameContext.Provider value={providerValue}>
			<Board></Board>
		</GameContext.Provider>
	);
}