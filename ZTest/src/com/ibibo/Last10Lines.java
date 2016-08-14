package com.ibibo;

import java.lang.reflect.Field;
import java.util.Arrays;

class MyClass
{
	private int id;
	private String name;
	private String address;
	
	public MyClass(int id, String name, String address) {
		this.id=id;
		this.name=name;
		this.address=address;
	}
}

public class Last10Lines {


	public static void main(String[] args) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
	
		MyClass o = new MyClass(1, "ABC", "US");
		//Class c= Class.forName("com.ibibo.MyClass");
		Class c=o.getClass();
		Field[] fields = c.getDeclaredFields();
		System.out.println(Arrays.toString(fields));
		
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i].getName());
			fields[i].setAccessible(true);
			System.out.println(fields[i].get(o));
		}
	}
	
	
}