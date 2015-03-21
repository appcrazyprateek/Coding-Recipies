package com.flipkart.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author PRATEEK
 *
 */
public class Ship {

	private int[] start;  //Row , col 
	private int[] end;  //Row, col
	private int size;  //Size of the ship
	private int hitsRequired=1;   //default hits required to kill the ship
	private boolean isAlive;   // is Ship alive
	private boolean isHotizontalAlign ;
	
	private List<ArrayList<Integer>> acitveCells ;  //List of array of active cells, format(row, col , hits)
	
	public Ship(int[] start, int[] end) throws Exception {
		this.start = start;
		this.end=end;
		
		if(start[0]==end[0])
		{
			size= Math.abs(start[1]-end[1]);
			isHotizontalAlign=true;
		}
		else if(start[1]==end[1]){
			size= Math.abs(start[0]-end[0]);
			isHotizontalAlign=false;
		}
		else
		{
			throw new Exception("Invalid Coordinate");
		}
		isAlive=true;
	}

	
	
	public int[] getStart() {
		return start;
	}

	public void setStart(int[] start) {
		this.start = start;
	}

	public int[] getEnd() {
		return end;
	}

	public void setEnd(int[] end) {
		this.end = end;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getHitsRequired() {
		return hitsRequired;
	}

	public void setHitsRequired(int hitsRequired) {
		this.hitsRequired = hitsRequired;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public boolean isHotizontalAlign() {
		return isHotizontalAlign;
	}

	public void setHotizontalAlign(boolean isHotizontalAlign) {
		this.isHotizontalAlign = isHotizontalAlign;
	}

	public List<ArrayList<Integer>> getAcitveCells() {
		return acitveCells;
	}

	public void setAcitveCells(List<ArrayList<Integer>> acitveCells) {
		this.acitveCells = acitveCells;
	}
	
	@Override
	public String toString() {
		return ""+Arrays.toString(start)+"-"+Arrays.toString(end); 
	}
}
