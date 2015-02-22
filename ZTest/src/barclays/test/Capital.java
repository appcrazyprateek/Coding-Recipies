package barclays.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Capital {

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
		
		List<Integer> dist = getDistances(capital, adjList, vistedStatus);

		//System.out.println(dist);
		
		int[] result = new int[T.length-1];
		int count = 0;
		int pos=0;
		int distLen = dist.size();
				
		for(i=0;i<distLen;i++)
		{
			if(dist.get(i)!=nil)
				count++;
			else
			{
				result[pos++]=count;
				count=0;
			}
			
		}
		System.out.println(Arrays.toString(result));
		return result;
    }
	
	 List<Integer> getDistances(int capital, Map<Integer,ArrayList<Integer>> adjList  ,Map<Integer,Boolean> vistedStatus )
	{
		List<Integer> neighbours= adjList.get(capital);
		List<Integer> result= new ArrayList<Integer>();
		
		vistedStatus.put(capital, true);
		
		result.addAll(neighbours);
		result.add(nil);
		
		int i=0;
		while(i<result.size())
		{
			int src = result.get(i);
			if(src!=nil)
			{
				vistedStatus.put(src, true);
				neighbours =  adjList.get(src);
				for(int j=0;j<neighbours.size();j++)
				{
					int neighbour = neighbours.get(j);
					//Do not add capital or any node which is already present
					if(neighbour!=capital && !vistedStatus.get(neighbour))
					   result.add(neighbour);
				}
				
			}
			else
			{
				//if two nulls gets back to back , all elements are processed, exit
				if(result.get(result.size()-1)==nil)
					break;
				else
				 result.add(nil);
			}
				i++;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] T= new int[]{9,1,4,9,0,4,8,9,0,1};
		Capital g = new Capital();
		g.solution(T);
	}
	
	
}
