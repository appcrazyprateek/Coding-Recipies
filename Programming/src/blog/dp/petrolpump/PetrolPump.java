package blog.dp.petrolpump;
/**
 * Petrol Pump Problem
 * @author Prateek
 */
 class PetrolPump {
	/**
	 * Get the Starting Point of the Circular Trip
	 * @return index of the petrol pump if solution exist ,
	 *           else -1 if solution doesnt exist
	 */
	public static int getStartIndex(int[] dist , int[] petrol){

		int nPumps= petrol.length;
		int start , currentPetrol;
		int i=start=0;

		while(start < nPumps)
		{
			currentPetrol= petrol[i] - dist[i] ;

			while(currentPetrol >= 0)	{
				
				i= (i+1) % nPumps ;

				currentPetrol += petrol [i] - dist[i] ;

				if(i==start)
					return start;
			}

			start = ++i ;
			i= i % nPumps ;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int [] dist =  {4, 7, 4, 8, 4, 1};
		int [] petrol =  {3, 5, 3, 8, 3, 6};

		int index= getStartIndex(dist, petrol);
		
		if(index == -1)
			System.out.println("Solution Does not exist");
		else
			System.out.println("Petrol Pump Number : " +(index + 1));
	}
}
