package blog.dp.petrolpump;

/**
 * Petrol Pump Problem
 * 
 * @author Prateek
 */
public class PetrolPump {

	/**
	 * Get the Starting Point of the Circular Trip
	 * 
	 * @return index of the petrol pump if solution exist , else -1 if solution
	 *         doesnt exist
	 * @throws Exception 
	 */
	public static int getStartIndex(int[] dist, int[] petrol) throws Exception {

		int nPumps = petrol.length;
		int start, currentPetrol;
		int sumDistance = 0;
		int sumPetrol = 0;
		
		for(int i=0;i<nPumps;i++) {
			sumDistance += dist[i];
			sumPetrol += petrol[i];
		}

		if(sumDistance > sumPetrol) 
			throw new Exception(
					"Solution does not exist, there is no petrol pump where race starts and completes the lap");
		
		
		int i = start = 0;
		while (start < nPumps) {
			currentPetrol = petrol[i] - dist[i];

			while (currentPetrol >= 0) {

				i = (i + 1) % nPumps;

				currentPetrol += petrol[i] - dist[i];

				if (i == start)
					return start;
			}

			start = ++i;
			i = i % nPumps;
		}
		return -1;
	}

	public static void main(String[] args) throws Exception {
		int[] dist = { 4, 7, 4, 8, 4, 1 };
		int[] petrol = { 3, 5, 3, 8, 3, 6 };

		int index = getStartIndex(dist, petrol);

		if (index == -1)
			System.out.println("Solution Does not exist");
		else
			System.out.println("Petrol Pump Number : " + (index + 1));
	}
}
