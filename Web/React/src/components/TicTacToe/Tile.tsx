import {useContext} from "react";
import {GameContext} from "./TicTacToe.tsx";

interface SquareProps {
	index: number;
	className?: string;
}

export function Tile(props: Readonly<SquareProps>) {
	let gameContext = useContext(GameContext);

	let hoverClass = null;
	if (gameContext?.squareArray[props.index] == null && !gameContext?.checkForWinner()) {
		hoverClass = gameContext?.isXPlayerTurn ? "hover-x" : "hover-o";
	}

	function handleClick(): void {
		if (gameContext && !gameContext?.squareArray[props.index] && !gameContext.checkForWinner()) {
			gameContext.squareArray[props.index] = gameContext.isXPlayerTurn ? "X" : "O"
			gameContext.setIsXPlayerTurn(!gameContext.isXPlayerTurn)
		}
	}

	return (
		<button className={`${hoverClass} tile ${props.className} tile-button`} onClick={handleClick}>
			{gameContext?.squareArray[props.index]}
		</button>
	)
}