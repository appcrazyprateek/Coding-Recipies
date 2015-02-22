package com.ibibo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * 
 * @author PRATEEK
 *
 */
public class RankApp {

	private static final String INPUT_FILE = "marks.txt";
	
	public static void main(String[] args) {
		Map<Integer,ArrayList<Student>> map = fileReader(INPUT_FILE);
		
		Set<Map.Entry<Integer,ArrayList<Student>>> set = map.entrySet();
		
		for(Map.Entry<Integer,ArrayList<Student>> entry: set)
		{
			int testCase = entry.getKey();
			System.out.println("******TestCase No. ******  "+testCase);
			setStudentRanks(entry.getValue());
		}
		
	}

	/**
	 * Sorts the array list and traverses once to set the ranks of the students
	 * @param studentList
	 */
	private static void setStudentRanks(List<Student> studentList) {
		int rank =1;
		Collections.sort(studentList);
		studentList.get(0).setRank(rank);
		System.out.println("Rank   Roll   Name   Total     Maths   Phy   Chem");
		
		Student currStudentObj=null;
		Student prevStudentObj =null;
		for(int i=1;i<studentList.size();i++)
		{
			 prevStudentObj = studentList.get(i-1);
			 currStudentObj = studentList.get(i);
			if(prevStudentObj.equals(currStudentObj))
				currStudentObj.setRank(rank);
			else
				currStudentObj.setRank(++rank);
			System.out.println(prevStudentObj);
		}
		System.out.println(currStudentObj);
	}

	/**
	 * Reads input file
	 * @return returns map of test case as key and arraylist of students as value
	 */
	private static Map<Integer, ArrayList<Student>> fileReader(String inputFile) {
		
		Map<Integer,ArrayList<Student>> map = null;
		try{
				BufferedReader br = new BufferedReader(new FileReader(new File(inputFile)));
				int numTestCases=  Integer.parseInt(br.readLine());
				
				map = new LinkedHashMap<Integer,ArrayList<Student>>();
				
				for(int i=0;i<numTestCases;i++)
				{
					ArrayList<Student> list = testCaseReader(br);
					map.put(i+1, list);
				}
		}	
		catch(Exception e)
		{
			System.err.print("Error in reading File");
		}
		return map;
	}

	/**
	 * Reads each test Case
	 * @param br
	 * @return arraylist of all the student objects 
	 */
	private static ArrayList<Student> testCaseReader(BufferedReader br) {
		ArrayList<Student> list = null;
		try{
			int numStudents = Integer.parseInt(br.readLine());
			list = new ArrayList<Student>(numStudents);
			String line="";
			while((line=br.readLine())!=null)
			{
				String[] params = line.split(" ");
				int roll = Integer.parseInt(params[0]);
				String name = params[1];
				int maths = Integer.parseInt(params[2]);
				int phy = Integer.parseInt(params[3]);
				int chem = Integer.parseInt(params[4]);
				
				Student student = new Student(roll,name,maths,phy,chem);
				list.add(student);
			}
		}
		catch(Exception e)
		{
			
		}
		return list;
	}
	
	
}
