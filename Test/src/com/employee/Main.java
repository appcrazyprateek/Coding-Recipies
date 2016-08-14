package com.employee;

import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		String txt = "";
		String pat = "";
		Main obj = new Main();
		obj.search(txt,pat);
	}

	private int search(String txt, String pat) {
		int txtLen = txt.length();
		int patLen = pat.length();
		int occurenceCount = 0;
		
		for(int i=0;i<txtLen;i++)
		{
			for(int j=0;j<patLen;j++)
			{
				if(txt.charAt(i) ==  pat.charAt(j))
				{
					i++;j++;
				}
				else if(j==patLen-1)
				{
					occurenceCount++;
				}
				else
					break;
			}
		}
		return occurenceCount;
		
	}
	
	
	
	
	
	
	
//
//	public static void main(String[] args) {
//		TreeSet<Employee> ts = new TreeSet<Employee>();
//		Employee e = new Employee();
//		e.empId = 1;
//		e.name = "A";
//		ts.add(e);
//		
//		Employee e1 = new Employee();
//		e1.empId = 1;
//		e1.name = "B";
//		ts.add(e1);
//		
//		for (Employee employee : ts) {
//			System.out.println(employee);
//		}
//	}

}

class EmpComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		int val  =  new Integer(o1.deptId).compareTo(o2.deptId);
		if(val == 0){
		 return new Integer(o1.empId).compareTo(o2.empId);
		}
		 return val;
	}
}


class Employee implements Comparable<Employee> {
	int empId;
	int deptId;
	String name;
	
	@Override
	public int compareTo(Employee o) {
		return new Integer(o.empId).compareTo(empId);
	}
	
	@Override
	public String toString() {
		
		return "empID: " + empId + " name: " + name;
	}

}
