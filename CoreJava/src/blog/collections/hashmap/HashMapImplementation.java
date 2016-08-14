package blog.collections.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapImplementation {

	public static void main(String[] args) {
		HashMap s=new HashMap();
		s.put(new Emp(10),1);
		s.put(new Emp(20),2);
		s.put(new Emp(30),3);
		s.put(new Emp(40),4);
		s.put(new Emp(50),5);
		s.put(new Emp(10),11);
		
		Set it=s.entrySet();
		Iterator i=it.iterator();
		while(i.hasNext())
		{
			Map.Entry entry = (Map.Entry)i.next();
			Emp e=(Emp)entry.getKey();
			System.out.println(entry.getValue() + " "+e.salary);
			//System.out.println(e.salary);
		}
	}
}
