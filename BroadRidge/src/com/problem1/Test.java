package com.problem1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Test {
	
	  public static void main(String args[] ) throws Exception {

	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      //  String line = br.readLine();
	        //int N = Integer.parseInt(line);
	        /*for (int i = 0; i < N; i++) {
	             
	        		String[] params= br.readLine().split(" ");
	        		int n= Integer.parseInt(params[0]);
	        		int k= Integer.parseInt(params[1]);
	        		int l= Integer.parseInt(params[2]);
	        		int q= Integer.parseInt(params[3]);
	        	
	        }
	        */
	        demo();
	        System.out.println("Hello World!");
	    }
	  
	  
	  public static void demo()
	  {
		  int n= 5;
		  int k=3;
		  int l=9;
		  int q = 5;
		  
		  List<HashMap<Integer,ArrayList<String>>> list = new ArrayList<HashMap<Integer,ArrayList<String>>>(k);
		  addItem("baryonyx 5 1 7".split(" "), list, n, k, l, q);
		  addItem("jobaria 1 2 3".split(" "), list, n, k, l, q);
		  addItem("oviraptor 9 7 1".split(" "), list, n, k, l, q);
		  addItem("troodon 6 9 5".split(" "), list, n, k, l, q);
		  addItem("minmi 7 4 5".split(" "), list, n, k, l, q);
		  
		  
		  findDinosaur(list,"9 7 1".split(" "),k);
		  findDinosaur(list,"1 2 3".split(" "),k);
		  findDinosaur(list,"5 8 8".split(" "),k);
		  findDinosaur(list,"1 2 3".split(" "),k);
		  findDinosaur(list,"7 4 5".split(" "),k);
	  }
	  
	  
	  public static void addItem(String[] line,List<HashMap<Integer,ArrayList<String>>> list,int n,int k, int l , int q){
		  String name = line[0];
		  
		  for(int i=1;i<line.length;i++)
		  {
			  int num = Integer.parseInt(line[i]);
			
			  HashMap<Integer,ArrayList<String>> item =  null;
			  
			  if(list.size()<i)
			  {
				   item  = new HashMap<Integer,ArrayList<String>>(n);
				   list.add(item);
			  }
			  else
				  item = list.get(i-1);
			  
			  ArrayList<String> dinosaurs= item.get(num);
			  if(dinosaurs==null)
			  {
				  dinosaurs = new ArrayList<String>();
			  }
			  dinosaurs.add(name);
			  item.put(num, dinosaurs);
		  }
	  }
	  
	  private static String findDinosaur(List<HashMap<Integer,ArrayList<String>>> list , String[] line, int k) {
          
		  int size= list.size();
		  Map<String,Integer> diasaursCount = new HashMap<String,Integer>();
		for(int i=0;i<size;i++)
		{
			int num = Integer.parseInt(line[i]);
			 HashMap<Integer,ArrayList<String>> item = list.get(i);
			List<String> dinasaurs= item.get(num);
			
			if(dinasaurs!=null)
			{
				for(int j=0;j<dinasaurs.size();j++)
				{
					String dinosaurName = dinasaurs.get(j);
					Integer count = diasaursCount.get(dinosaurName);
					if (count == null) {
						diasaursCount.put(dinosaurName, 1);
						if(1==k)
							return dinosaurName;
					}
					else {
						diasaursCount.put(dinosaurName, count + 1);
						if(count+1==k)
							return dinosaurName;
					}

				}
			}
			
		}
		    System.out.println("You cant fool me :P");
			return "You cant fool me :P";
	   }
}