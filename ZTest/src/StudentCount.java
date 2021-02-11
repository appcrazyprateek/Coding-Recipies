import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Student {
	private String name;
	private int weight;
}



public class StudentCount {

	
	public List<Student> findWinner(List<Student> votes) {
		
		
		Map<String, Integer> names = new HashMap<>();
		for(Map<String,Integer> map :  votes)
		{
			Iterator<String> namesIt = map.keySet().iterator();
			while(namesIt.hasNext()) {
				String name = namesIt.next();
				
				if (!names.containsKey(name))
					names.put(name, map.get(name));
				else
					names.put(name, names.get(name) + map.get(name));
			}
		}
		
		
		return null;
		
	}
	
	
	public List<String> findWinner1(List<String> votes) {

		if (votes == null || votes.isEmpty())
			return new ArrayList<String>(0);

		//O(n)
		int max
		Map<String, Integer> names = new HashMap<>();
		for (String name : votes) {
			if (!names.containsKey(name))
				names.put(name, 1);
			else
				names.put(name, names.get(name) + 1);
		}

		//O(n)
		// calculating the max
		Iterator<Integer> valuesIt = names.values().iterator();
		int max = Integer.MIN_VALUE;
		while (valuesIt.hasNext())
			max = Math.max(valuesIt.next(), max);

		//O(n)
		List<String> result = new ArrayList<>();
		Iterator<String> namesIt = names.keySet().iterator();
		while (namesIt.hasNext()) {
			String n = namesIt.next();
			if (names.get(n) == max)
				result.add(n);
		}
		//O(2n)
		return result;
	}

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("Ravi");
		names.add("Tom");
		names.add("Jamie");
		names.add("Ravi");
		names.add("Prateek");
		names.add("Tom");

		StudentCount studentCount = new StudentCount();
		List<String> result = studentCount.findWinner(names);
		System.out.println(Arrays.toString(result.toArray()));

	}

}
