package com.flipkart.beans;

import java.util.ArrayList;
import java.util.List;
import com.flipkart.constants.BattleConstants;
import com.flipkart.service.BoardService;
/**
 * Holds player's identity, its ships and the current active cells
 * @author PRATEEK
 *
 */

public class Player {

	public int id; 
	private String name;
	private int numShips;  //no. of ships the player holds
	private List<Ship> ships;    //List of the ships player has
	private List<int[]> activeCells;  //Current cells which are occupied by ships
	
	
	public Player(int numShips, int id, String name) {
		this.id=id;
		this.numShips=numShips;
		this.name=name;
	}
	
	public String play(int row, int col){
		String msg =  BoardService.getInstance().play(row, col, this);
		System.out.println(msg);
		if(msg.contains("won"))
			System.exit(0);  
		return msg;
	}

	public void setShip(int r1,int c1 , int r2 , int c2) throws Exception {
		int[] start = {r1,c1};
		int[] end = {r2,c2};
		
		Ship ship = new Ship(start,end);

		if(ships==null)
		{
			ships= new ArrayList<Ship>(numShips);
		}
		ships.add(ship);
	}
	
	/**
	 * Called once all the ships are entered
	 */
	public void done(){
		
		for(Ship ship:ships)
		{
			
			int[] start = ship.getStart();
			int[] end = ship.getEnd();
			
			boolean isHorizontal = false;
			if(start[0]==end[0])
				isHorizontal= true;
			
			int len=0;
			if(isHorizontal)
				len  = Math.abs(start[1] - end[1]);
			else
				len  = Math.abs(start[0] - end[0]);
			
				int r=start[0];
				int c=start[1];
				for(int i=0;i<=len;i++)
				{
					int arr[] = new int[3];
					if(isHorizontal)
					{
						arr[0]=r;
						arr[1]=c+i;
					}
					else
					{
						arr[0]=r+i;
						arr[1]=c;
					}
					
					//isMagicalCell(r,c) //TODO : Scale: if matrix has magical cells
					arr[2]=ship.getHitsRequired();   
					if(activeCells==null)
						activeCells= new ArrayList<int[]>();
					activeCells.add(arr);	
				}
		}
	}

	public int getNumShips() {
		return numShips;
	}

	public void setNumShips(int numShips) {
		this.numShips = numShips;
	}

	public List<Ship> getShips() {
		return ships;
	}

	public void setShips(List<Ship> ships) {
		this.ships = ships;
	}

	public List<int[]> getActiveCells() {
		return activeCells;
	}

	public void setActiveCells(List<int[]> activeCells) {
		this.activeCells = activeCells;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	/*
	 * TODO: scale for super ships
	 * For differnt Types of Ships
	 */
	public void setShip(int r1,int c1 , int r2 , int c2, BattleConstants.SHIP_TYPE shipType) throws Exception {
		int[] start = {r1,c1};
		int[] end = {r1,c1};
		
		Ship ship = new Ship(start,end);
		
		//If the ship is a super ship , set the hits to 2
		if(shipType.getVal() == BattleConstants.SHIP_TYPE.SUPER_SHIP.getVal())
			ship.setHitsRequired(2);
		
		if(ships==null)
		{
			ships= new ArrayList<Ship>(numShips);
		}
		ships.add(ship);
		
	}
}