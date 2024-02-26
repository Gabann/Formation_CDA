import {Square} from "./Square.tsx";
import {useContext} from "react";
import {GameContext} from "./TicTacToe.tsx";

export function Board() {
	let gameContext = useContext(GameContext);

	const winMessage = gameContext?.checkForWinner();
	let status;
	if (winMessage) {
		status = winMessage;
	} else {
		status = 'Next player: ' + (gameContext?.isXPlayerTurn ? 'X' : 'O');
	}

	return (
		<>
			<div className="status">{status}</div>

			<div className='game-board'>
				<div className='row'>
					<div>
						<Square index={0}></Square>
						<Square index={1}></Square>
						<Square index={2}></Square>
					</div>
				</div>
				<div className='row'>
					<div>
						<Square index={3}></Square>
						<Square index={4}></Square>
						<Square index={5}></Square>
					</div>
				</div>
				<div className='row'>
					<div>
						<Square index={6}></Square>
						<Square index={7}></Square>
						<Square index={8}></Square>
					</div>
				</div>
			</div>
		</>
	);
}