package com.classloader;

import java.lang.reflect.Field;

public class ClassLoaderTester {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		CustomClassLoader obj= new CustomClassLoader();
		Class myClass=obj.findClass("Hello");
		
		System.out.println(myClass.getCanonicalName());
		//System.out.println(myClass.getDeclaredFields());
		//System.out.println(myClass.getDeclaredField("jarFile"));
		
		Field[] filds = myClass.getDeclaredFields();
		for(Field f:filds)
			System.out.println(f.getName());
		
	}
}
