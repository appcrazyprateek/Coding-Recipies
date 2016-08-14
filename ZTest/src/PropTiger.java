
public class PropTiger {

	public int solution(int[] A) {
		boolean[] visited = new boolean[A.length];
		int i = 0;
		while (i >= 0 && i < A.length) {
			visited[i] = true;
			if (A[i] == 0)
				break;
			i += A[i];
		}
		int numUnvisited = 0;
		for (i = 0; i < visited.length; i++)
			if (!visited[i])
				numUnvisited++;
		return numUnvisited;
	}
	
}
