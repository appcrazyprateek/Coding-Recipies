package barclays.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Capital2 {

	int nil = 99999;
	public  int[] solution(int[] T) {
		int len = T.length;
		int capital = nil;
		int i=0;
		
		Map<Integer,ArrayList<Integer>> adjList = new HashMap<Integer,ArrayList<Integer>>(len);
		Map<Integer,Boolean> vistedStatus = new HashMap<Integer,Boolean>(len);
		
		for(;i<len;i++)
		{
			int src = i;
			int dest = T[i];
			
			if(src == dest)
			{
					capital=src;
					continue;
			}
			
			//Fwd edge
			ArrayList<Integer> list=adjList.get(src);	
			if(list==null)
				list=new ArrayList<Integer>();
			
			list.add(dest);
			adjList.put(src,list);	
			vistedStatus.put(src, false);  
			
			// reverse edge
			list=adjList.get(dest);			
			if(list==null)
				list=new ArrayList<Integer>();

			list.add(src);
			adjList.put(dest,list);	
			vistedStatus.put(src, false);  
		}
		
		return getDistances(capital, adjList, vistedStatus);
    }
	
	 int[] getDistances(int capital, Map<Integer,ArrayList<Integer>> adjList  ,Map<Integer,Boolean> vistedStatus )
	{
		List<Integer> neighbours= adjList.get(capital);
		Queue<Integer> queue= new LinkedList<Integer>();
		
		vistedStatus.put(capital, true);
		List<Integer> result= new ArrayList<Integer>();
		int[] r= new int[adjList.size()];
		queue.addAll(neighbours);
		queue.add(nil);
		
		int count = 0,level=0;
		while(!queue.isEmpty())
		{
			int pop=queue.poll();
			
			if(pop == nil)
			{
				result.add(count);
				r[level++]=count;
				count =0;
				
				if(queue.isEmpty())
					break;
				queue.add(nil);
			}
			else
			{
				count++;
				neighbours= adjList.get(pop);
				vistedStatus.put(pop, true);
				for(int i=0;i<neighbours.size()-1;i++)
				{
					int neighbour = neighbours.get(i);
					if(!vistedStatus.get(neighbour) && neighbour!=capital)
					{
						queue.add(neighbours.get(i));
						
					}
				}
			}
		} 
		System.out.println(Arrays.toString(r));
		return r;
	}
	
	public static void main(String[] args) {
		int[] T= new int[]{9,1,4,9,0,4,8,9,0,1};
		Capital2 g = new Capital2();
		g.solution(T);
	}
	
	
}
