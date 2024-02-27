import {Tile} from "./Tile.tsx";
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
		<div className='board-container'>
			<div className="status p-4">{status}</div>


			<div className='game-board'>
				<div className="strike"/>
				<Tile index={0} className="right-border bottom-border"></Tile>
				<Tile index={1} className="right-border bottom-border"></Tile>
				<Tile index={2} className="bottom-border"></Tile>
				<Tile index={3} className="right-border bottom-border"></Tile>
				<Tile index={4} className="right-border bottom-border"></Tile>
				<Tile index={5} className="bottom-border"></Tile>
				<Tile index={6} className="right-border"></Tile>
				<Tile index={7} className="right-border"></Tile>
				<Tile index={8}></Tile>
			</div>


			<button className={'reset-button'} onClick={gameContext?.resetGame}>Reset</button>
		</div>
	);
}