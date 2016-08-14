package com.flipkart.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;


public class Solution {

	private final static String SPACE = " ";
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int numNodes  = Integer.parseInt(br.readLine());
		 String[] strNodes = br.readLine().split(SPACE);
		 int[] nodes = new int[numNodes];
		
		 for(int i = 0;i < numNodes;i++)
			 nodes[i] = Integer.parseInt(strNodes[i]);
		 
		 solve(nodes,numNodes);
	}

	private static void solve(int[] nodes, int len) {
		
		List<Integer> queue = new ArrayList<Integer>();
		
		//Create MAP
		Map<Integer,ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for(int i=0;i<len;i++)
		{
			int key = nodes[i];
			ArrayList<Integer> list = map.get(key);
			if(list==null)
				list = new ArrayList<Integer>();
			
			list.add(i);
			map.put(key, list);
		}
		
		List<Integer> list = map.get(-1);
		if(list==null)
			return;
		
		queue.add(list.get(0)); //root element
		queue.add(null);
		
		boolean consecutiveNulls=true;
		
		for(int i=0;i<queue.size();i++)
		{
			Integer parent = queue.get(i);
			if(parent == null)
			{
				if(consecutiveNulls)
					break;
				queue.add(null);
				consecutiveNulls=true;
				continue;
			}
				
			consecutiveNulls = false;
			List<Integer> childs = map.get(parent);
			if(childs!=null)
			queue.addAll(childs);
		}
		
		printReverseTree(queue);
	}
	

	public static void printReverseTree(List<Integer> a) {
		Stack<Integer> s = new Stack<Integer>();
		int i;
		for(i=a.size()-1; i>=0; i--){
			if(a.get(i)==null)
				continue;
			else
				break;
		}
		
		for (; i >= 0; i--) {
			if (a.get(i) != null) {
				s.push(a.get(i));
				if (i == 0)
					System.out.print(a.get(i));
			} 
			else {
				while (!s.isEmpty()) {
					System.out.print(s.pop() + SPACE);
				}
				System.out.println();
			}

		}
	}	
}
