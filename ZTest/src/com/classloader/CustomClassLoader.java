package com.classloader;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class CustomClassLoader extends ClassLoader {

	
	 public String jarFile = "C:/junk/test.jar"; //Path to the jar file
	 public Map classes = new HashMap<String, Class>(); //used to cache already defined classes

	    public CustomClassLoader() {
	        super(CustomClassLoader.class.getClassLoader()); //calls the parent class loader's constructor
	    }
	
	 public Class loadClass(String className) throws ClassNotFoundException {
	        return findClass(className);
	    }

	    public Class findClass(String className) {
	        byte classByte[];
	        Class result = null;

	        result = (Class) classes.get(className); //checks in cached classes
	        if (result != null) {
	            return result;
	        }

	        try {
	            return findSystemClass(className);
	        } catch (Exception e) {
	        }

	        try {
	            JarFile jar = new JarFile(jarFile);
	            JarEntry entry = jar.getJarEntry(className + ".class");
	            InputStream is = jar.getInputStream(entry);
	            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
	            int nextValue = is.read();
	            while (-1 != nextValue) {
	                byteStream.write(nextValue);
	                nextValue = is.read();
	            }

	            classByte = byteStream.toByteArray();
	            result = defineClass(className, classByte, 0, classByte.length, null);
	            classes.put(className, result);
	            return result;
	        } catch (Exception e) {
	            return null;
	        }
	    }
}
