package blog.eggandfloor;
/**
 * TODO: improve the solution
 * @author PRATEEK
 *
 */
public class EggAndFloorProblem {
static	int min=Integer.MAX_VALUE;
	public static int dropEgg(int numEggs, int numFloors){
		
		if(numFloors==0 || numFloors==1)
		{
			return numFloors;
		}
		
		if(numEggs==1)
		{
			return numFloors;
		}
		
	
		int result;
		
		for(int currFloor=1;currFloor<=numFloors;currFloor++)
		{
			result = Math.max(dropEgg(numEggs-1, currFloor-1), dropEgg(numEggs, numFloors - currFloor ));
			if(result<min)
				min=result;
		}
		
		return min+1;
	}
	
	
	public static void main(String[] args) {
		System.out.println(dropEgg(2,10));
	}
	
}
