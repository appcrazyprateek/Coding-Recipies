package com.flipkart.constants;

public class BattleConstants {

	public enum SHIP_TYPE{
		NORMALSHIP(0),
		SUPER_SHIP(1);
		
		private int val ;
		
		public int getVal() {
			return val;
		}
		private SHIP_TYPE(int val)
		{
			this.val=val;
		}
	}
	
	
	public enum STATUS{
		HIT_FAILURE(0),
		HIT_SUCCESS(1),
		GAME_WON(2),
		INVALID_MOVE(3);
		
		private int val ;
		
		public int getVal() {
			return val;
		}

		private STATUS(int val)
		{
			this.val=val;
		}
	}
}
