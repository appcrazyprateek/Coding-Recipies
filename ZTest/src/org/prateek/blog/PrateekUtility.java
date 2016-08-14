package org.prateek.blog;
import java.lang.reflect.Field;
import java.util.Collections;

class Emp {

	public Integer id;
	public String name;
	public Address address;
	
	public Emp(int id, String name, Address add) {
		 this.id = id;
		 this.name = name;
		 this.address = add;
	}
}
class Address  {

	public String homeAdd;
	public String offAdd;
	
	public Address(String home, String off) {
		this.homeAdd = home;
		this.offAdd = off;
	}
}

/**
 * 
 * @author Prateek
 */
public class PrateekUtility {
	private static StringBuilder builder = new StringBuilder();

	public static String toString(Object object) throws IllegalArgumentException, IllegalAccessException{
		Class c=object.getClass();
		Field[] field=c.getDeclaredFields();
		builder.append(" { ");
		for(int i=0;i<field.length;i++){
			Field f=field[i];
			String name = f.getName();
			builder.append(name+ " : ");
			if(f.getType().isPrimitive() || !isValidObject(f))
				//System.out.println(f.get(object));
				builder.append(f.get(object));
			else
			{
				Object value = f.get(object);
				toString(value);
			}
			if(i+1!=field.length)
				builder.append(" , ");
		}
		builder.append(" } ");
		return builder.toString();
	}


	public static boolean isValidObject(Field f){
		String type=f.getType().toString();
		if(type.contains("String") ||
				type.contains("Integer") ||
				type.contains("Double") ||
				type.contains("Float") ||
				type.contains("Short") ||
				type.contains("Byte") ||
				type.contains("Boolean"))
			return false;
		
		return true;
	}

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		int i=1;
		
		assert i==1;
		
		
		/*Emp e = new Emp(1, "Prateek", new Address("myhome", "myoffice"));
		System.out.println(PrateekUtility.toString(e));*/
	}
}
