package blog.dp.coinchange;

/**
 * Coin Change Problem
 * @author Prateek
 *
 */
 public class CoinChange {
	static int[] coins = { 30 ,24 , 12 , 6 , 3 , 1 };
	static int W = 53 ;

	/*static int[] coins = { 1 , 2 , 5 };
	static int W = 7 ;*/
	
    
	public static void main(String[] args) {

		CoinChange obj=new CoinChange();
		obj.coinChange(coins, 1);
		System.out.println("Minimum Coins Required : " + fValues[W]);
		System.out.println("Coin denomindations required are :");
		obj.print(W);
	}

	static int index=0;
	static int [] S = new int[W + 1];
	static int[] fValues= new int[W+1] ;

	public void coinChange(int[] coins , int w){

		if(w > W)
			return ;

		int min=w , fValue , coin = 0;
	
		for(int i=0;i<coins.length ;i++) {
			if(w >= coins[i]) {

				fValue = fValues[w-coins[i]] ;
				
				if(min > fValue)
				{
					min = fValue;
					coin=i;
				}
			}
		}
		fValues[++index] = min +1 ;
		
		S[w] = coin ;
		coinChange(coins , w + 1);
	}
	
	public void print(int W ){
		while(W>0)		{
			System.out.print(coins[S[W]] + "\t");
			W=W-coins[S[W]];
		}
	}
}
