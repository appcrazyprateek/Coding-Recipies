package com.amazon.ecp;


import java.util.*;
import java.lang.*;
import java.io.*;

class Stockroom
{
	private int numVertices;
	private int numEdges;
	
	public Stockroom() {
		this.adjList = new HashMap<Integer,ArrayList<Integer>>();
		this.vistedStatus = new HashMap<Integer, Boolean>() ;
	}
	
	//Map to maintain adjacency List
	private Map<Integer,ArrayList<Integer>> adjList;
	// Map to maintain visit status
	private static Map<Integer, Boolean> vistedStatus;
	
	
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] params= br.readLine().trim().split(" ");
		int T = Integer.parseInt(params[0]); //Total number of airports
		int N = Integer.parseInt(params[1]); //Total connections between the airports
		Stockroom obj = new Stockroom();
		
		//Edges 
		for(int i=0;i<N;i++){
			String[] edge = br.readLine().trim().split(" ");
			obj.addEdge(Integer.parseInt(edge[0]), Integer.parseInt(edge[1]));
		}
		
		
		int Q = Integer.parseInt(br.readLine().trim());
		for(int i=0;i<Q;i++)
		{
			String[] query = br.readLine().trim().split(" ");
			Map<Integer, Boolean> vistedStatusClone  = obj.cloneVisitStatusMap(vistedStatus);
			System.out.println(obj.isConnected(Integer.parseInt(query[0]), Integer.parseInt(query[1]),vistedStatusClone));
		}
	}
	
	private Map<Integer, Boolean> cloneVisitStatusMap(Map<Integer, Boolean> vistedStatus) {
		Map<Integer, Boolean> vistedStatusClone  = new HashMap<Integer, Boolean>() ;
		for(Map.Entry<Integer, Boolean> entry : vistedStatus.entrySet())
			vistedStatusClone.put(entry.getKey(), entry.getValue());
		return vistedStatusClone;
	}




	public static void main1(String[] args) {
		testCase1();
		System.out.println("=========");
		testCase2();
	}
	
	public static void testCase1(){
		Stockroom obj = new Stockroom();
		
			obj.addEdge(0,1);
			obj.addEdge(1,2);
			obj.addEdge(0,2);
			obj.addEdge(3,4);
			obj.addEdge(4,5);
			Map<Integer, Boolean> vistedStatusClone  = obj.cloneVisitStatusMap(vistedStatus);
			System.out.println(obj.isConnected(0,5,vistedStatusClone));
			vistedStatusClone  = obj.cloneVisitStatusMap(vistedStatus);
			System.out.println(obj.isConnected(3,5,vistedStatusClone));
	}
	
	
	public static void testCase2(){
		Stockroom obj = new Stockroom();
		
			obj.addEdge(0,3);
			obj.addEdge(3,1);
			obj.addEdge(1,3);
			obj.addEdge(3,4);
			obj.addEdge(4,2);
			Map<Integer, Boolean> vistedStatusClone  = obj.cloneVisitStatusMap(vistedStatus);
			System.out.println(obj.isConnected(0,2,vistedStatusClone));
			vistedStatusClone  = obj.cloneVisitStatusMap(vistedStatus);
			System.out.println(obj.isConnected(4,0,vistedStatusClone));
			vistedStatusClone  = obj.cloneVisitStatusMap(vistedStatus);
			System.out.println(obj.isConnected(2,3,vistedStatusClone));
			
	}
	
	
	
	
	Integer isConnected(Integer startNode , Integer dest,Map<Integer, Boolean> vistedStatusClone ) {
		Queue<Integer> bfsQueue = new LinkedList<Integer>();

		// stating node visit status set to true
		vistedStatusClone.put(startNode, true);

		// start node added to Queue
		bfsQueue.add(startNode);

		while(!bfsQueue.isEmpty())
		{
			// Node poped from Queue
			int node=bfsQueue.poll();
			if(node == dest)
				return 1;

			// all connected node list of a give node
			List<Integer> list=adjList.get(node);

			int size=list.size();
			for(int i=0;i <size; ++i)
			{
				int adjNode=list.get(i);
				boolean isVisited=vistedStatusClone.get(adjNode);
				if(!isVisited)
				{
					vistedStatusClone.put(adjNode, true);
					bfsQueue.add(adjNode);
				}
			}
		}
		return 0;
	}
	
	private void addEdge(int src, int dest) {

		/*Forward Edge */
		ArrayList<Integer> list=adjList.get(src);			
		if(list==null)
			list=new ArrayList<Integer>();

		list.add(dest);
		adjList.put(src,list);	
		vistedStatus.put(src, false);  //visit status set to false

		/* Reverse Edge */
		list=adjList.get(dest);			
		if(list==null)
			list=new ArrayList<Integer>();

		list.add(src);
		adjList.put(dest,list);	
		vistedStatus.put(dest, false);  //visit status set to false
	}

	
}
