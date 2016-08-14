package com.tictactoe.action;

import java.util.Scanner;
import com.tictactoe.dataobject.Board;
import com.tictactoe.dataobject.GameState;
import com.tictactoe.dataobject.Seed;

public class GameController {
	private Board board ;
	private Seed currentPlayer ;
	private GameState gameState ;
	
	private Scanner scanner = new Scanner(System.in);
	
	public GameController(int rows, int cols) throws Throwable {
		board = new Board(rows, cols);
		initGame();
		startGame();
	}

	private void initGame() {
		board.init();
		currentPlayer = Seed.CROSS ;
		gameState = GameState.PLAYING;
	}
	
	private void startGame() {
		do {
			playerMove(currentPlayer);
			gameState = checkGameState(currentPlayer);
			board.paint();
			currentPlayer = currentPlayer == Seed.CROSS ? Seed.NOUGHT : Seed.CROSS ;
		}while(gameState == GameState.PLAYING);
		
		if(gameState == GameState.CROSS_WON)
			System.out.println("X Won the Game");
		else if(gameState ==GameState.NOUGHT_WON )
			System.out.println("O Won the Game");
		else
			System.out.println("Its a Draw");
	}

	private GameState checkGameState(Seed seed) {
		if(board.hasWon(seed))
			return seed == Seed.CROSS ? GameState.CROSS_WON : GameState.NOUGHT_WON;
		if(board.isDraw())
			return GameState.DRAW;
		return GameState.PLAYING;
	}

	private void playerMove(Seed player) {
		System.out.println("Player "+player.getContent() + " turn , Enter Row and Column" );
		int row = -1;
		int col = -1;
		do {
			 row = scanner.nextInt();
			 col = scanner.nextInt();
		}while(!isValidInput(row, col));
		
		board.cells[row][col].content = player ;
		board.currRow=row;
		board.currCol=col;
	}
	
	boolean isValidInput(int row, int col) 
	{
		if (row < 0 || col < 0 || row >= board.ROWS || col > board.COLS) 
		{
			if (!(board.cells[row][col].content == Seed.EMPTY)) {
				System.err.println("Invalid Input : (" + row + "," + col
						+ ") try again");
				return false;
			}
		}
		return true;
	}
}
