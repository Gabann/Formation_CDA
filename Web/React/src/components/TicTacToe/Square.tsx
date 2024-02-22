import {useContext} from "react";
import {GameContext} from "./TicTacToe.tsx";

interface SquareProps {
    index: number;
}

export function Square({index}: Readonly<SquareProps>) {
    let gameContext = useContext(GameContext);

    function handleClick(): void {
        if (gameContext && !gameContext?.squareArray.current[index] && !gameContext.checkForWinner()) {
            gameContext.squareArray.current[index] = gameContext?.isXPlayerTurn ? "X" : "O"
            gameContext.setIsXPlayerTurn(!gameContext?.isXPlayerTurn)
            console.log(gameContext.checkForWinner());
        }
    }

    return (
        <button className='btn square' onClick={handleClick}>{gameContext?.squareArray.current[index]}</button>
    )
}