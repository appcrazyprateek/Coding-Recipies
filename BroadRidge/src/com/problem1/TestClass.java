package com.problem1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestClass {

	public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //  String line = br.readLine();
        //int N = Integer.parseInt(line);
        //for (int i = 0; i < N; i++) {
          String  line = br.readLine();
            int n = Integer.parseInt(line.split(" ")[0]);
            int k = Integer.parseInt(line.split(" ")[1]);
            int l = Integer.parseInt(line.split(" ")[2]);
            int q = Integer.parseInt(line.split(" ")[3]);
            List<HashMap<Integer,ArrayList<String>>> list = new ArrayList<HashMap<Integer,ArrayList<String>>>(k);
   		   
            // N Items 
            for(int x = 0;x<n;x++)
            {
            	 line = br.readLine();
            	 addItem(line.split(" "), list, n, k, l, q);
            }
            
            //Q Item
            for(int x = 0;x<n;x++)
            {
            	 line = br.readLine();
            	String name= findDinosaur1(list, line.split(" "), k);
            	System.out.print(name);
            }
      //  }
        
    }
	
	
	
	
	
	private static void addItem1(String[] split,
			List<HashMap<Integer, ArrayList<String>>> list, int n, int k,
			int l, int q) {
		
		
	}





	private static String findDinosaur1(
			List<HashMap<Integer, ArrayList<String>>> list, String[] split,
			int k) {
		// TODO Auto-generated method stub
		return null;
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
			return "You cant fool me :P";
	   }
	  
	
}
