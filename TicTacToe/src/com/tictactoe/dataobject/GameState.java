package com.tictactoe.dataobject;

public enum GameState {
	DRAW(0), PLAYING(1), CROSS_WON(2), NOUGHT_WON(3)  ;

	int state; 
	private GameState(int val) {
		state = val;
	}
	
	public int getState() {
		return state;
	}
}
