package com.flipkart.action;

import com.flipkart.beans.Board;
import com.flipkart.beans.Player;
import com.flipkart.service.BoardService;
/**
 * Excutes the Battleship game
 * @author PRATEEK
 *
 */
public class BattleShip {
	
	public static void main(String[] args) {
		try {
			initializeBoard(2,1);  //Size of board , number of ships
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	private static void initializeBoard(int N, int numShips) throws Exception {
	
		Board.createBoard(N);
		
		Player p1 = new Player(numShips,1,"Amazon");
		Player p2 = new Player(numShips,2,"Flipkart");
		
		p1.setShip(0,1,1,1);
		//p1.setShip(1,0,3,0);
		//p1.setShip(2,4,5,4);
		p1.done(); //call after the ships are entered for the player
		
		p2.setShip(0,0,1,0);
		//p2.setShip(7,2,7,4);
		//p2.setShip(7,5,7,7);
		p2.done();  //call after the ships are entered for the player
		
		BoardService service = BoardService.getInstance();
		service.player1=p1;
		service.player2=p2;
		
		p1.play(0, 0);
		p2.play(0, 1);
		
		p1.play(1, 0);
		/*p1.play(0, 1);
		p2.play(0, 4);
		
		p1.play(7, 3);
		p2.play(3, 0);
		
		p1.play(6, 5);
		p2.play(2, 0);*/
		
	}
}
