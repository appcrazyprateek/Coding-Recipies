

import java.util.*;
import java.util.Map.Entry;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Stockroom
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); 
		String[] inputs = new String[N];
		for(int i = 0;i<N;i++)
		{
			inputs[i] = br.readLine().trim();
		}
		
		String query = br.readLine().trim();
		int printCount = 3; //given by invigilator
		
		Stockroom obj = new Stockroom();
		obj.process(query, inputs,printCount);
	}
	
	private  void process(String query, String[] inputs, int printCount ) {
		
		Map<Integer,TreeSet<String>> treeMap = new TreeMap<Integer,TreeSet<String>>();
		for(int i=0;i<inputs.length;i++){
			int distance  = wordEditDistance(new String(query),new String(inputs[i]));
			TreeSet<String> list = treeMap.get(distance);
			
			if(list == null)
				list = new TreeSet<String>();
			list.add(inputs[i]);
			treeMap.put(distance, list);
		}
		
	
		Set<String> treeSet = new LinkedHashSet<String>();
		int i = 0;
		for(Entry<Integer, TreeSet<String>> entry : treeMap.entrySet())
		{
			TreeSet<String> set = entry.getValue();
			for(String val : set)
			{
				if(i==printCount)
					break;
				i++;
				treeSet.add(val);
			}
			
		}
		
		printSolution(treeSet);
	}
	
	private void printSolution(Set<String> treeSet) {
			for(String entry : treeSet){
					System.out.println(entry);
			}
	}
	public  int wordEditDistance(String source, String target) {
        int sLen = source.length();
        int tLen = target.length();

        int[][] dist = new int[sLen + 1][tLen + 1];
        int i = 0, j = 0;

        for (i = 1; i < sLen + 1; ++i)
            dist[i][0] = i;

        for (j = 1; j < tLen + 1; ++j)
            dist[0][j] = j;

        for (i = 1; i < sLen + 1; ++i) {
            for (j = 1; j < tLen + 1; ++j) {
                int d1 = dist[i - 1][j] + 1;
                int d2 = dist[i][j - 1] + 1;
                int d3 = dist[i - 1][j - 1] + ((source.charAt(i - 1) == target.charAt(j - 1)) ? 0 : 1);

                dist[i][j] = Math.min(d1, Math.min(d2, d3));

            }
        }
        return dist[sLen][tLen];
    }
}
	

