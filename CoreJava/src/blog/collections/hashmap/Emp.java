package blog.collections.hashmap;

public class Emp  { //implements Comparable  {

	
   public	int salary;
	
	public Emp(int salary )
	{
		this.salary=salary;
	}

	public boolean equals(Object o)
	{
		Emp e=(Emp)o;
		if(e.salary==this.salary)
			return true;
		else
		return false;
	}
	
/*	public int hashCode()
	{
		return salary*10;
	}*/

	/*@Override
	public int compareTo(Object o) {
		
		Emp e=(Emp)o;
		if(e.salary>this.salary)
			return 1;
		else if(e.salary>this.salary) 
			return -1;
		else
		return 0;
	}*/
}
