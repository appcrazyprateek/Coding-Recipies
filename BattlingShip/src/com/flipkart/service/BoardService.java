package com.flipkart.service;

import java.util.List;

import com.flipkart.beans.Board;
import com.flipkart.beans.Player;

public class BoardService {
	
	public 	Player player1;
	public  Player player2;
	public static BoardService service; 
	
	public BoardService() {
		
	}
	
	public static BoardService getInstance()
	{
		if(service==null)
		{
			service = new BoardService();
		}
		return service;
	}
	
	public String play(int row, int col, Player p ){
		
		boolean isVacant = isMoveValid(row, col);
		boolean hit=false;
		boolean gameWon=false;
		String msg="";
		
		if(p.id == player1.id)
		{
			hit = hitTarget(row,col,player2);
			 gameWon = false;
			if(hit)
			gameWon = isGameWon(player2);
			
		}
		else
		{
			  hit = hitTarget(row,col,player1);
			  gameWon = false;
				if(hit)
			 gameWon = isGameWon(player1);
		}
		msg = prepareMSG(hit, gameWon , isVacant);
		return p.getName()+" " + msg; 
	}
	
	private boolean isGameWon(Player p) {
		if(p.getActiveCells().size()==0)
		{
			return true;
		}
		else 
			return false;
		
	}

	private boolean isMoveValid(int row,int col) {
		Board b = Board.getInstance();
		if(b.getBoard()[row][col]==1 && (b.getSize()>=row || b.getSize()>= col) )
		{
			return false;
		}
		return true;
	}

	private boolean hitTarget(int row, int col, Player p){
		
		List<int[]> activeCells = p.getActiveCells();
		for(int i=0;i<activeCells.size();i++)
		{
			int[] arr = activeCells.get(i);
			if(arr[0]==row && arr[1]==col)
			{
				int val = --arr[2];
				arr[2]=val;
				if(arr[2]==0)
				activeCells.remove(i);
				markBoard(row, col);
				return true;
			}
		}
		return false;
	}

	private void markBoard(int row, int col) {
		Board b = Board.getInstance();
		b.getBoard()[row][col]=1;
	}
	
    private String prepareMSG(boolean hit , boolean gameWon , boolean isValidMove) {
		if(isValidMove)
		{
			if(gameWon)
			{
			  return "won Game";	
			}
			else
			{
				if(hit)
					return "it was a Hit";
				else
					return "it was a Miss";
			}
		}
		else
		{
			return "Invalid Move";
		}
	}
}
