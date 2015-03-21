package com.birst;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Folder Compare contents of two folders 
 * @author PRATEEK
 *
 */
public class FileComparator {

	private static final String folder1 = "D:\\ComparisonFolder\\master";
	private static final String folder2 = "D:\\ComparisonFolder\\release";
	
	private static final String IDENTICAL = "Identical";
	private static final String DIFFERENT = "Different";
	
	//Set to hold union of files
	private static Set<String> unionFiles = new LinkedHashSet<String>();
	
	public static void main(String[] args) throws IOException {
		
		File[] root1 = new File(folder1).listFiles();
		File[] root2 = new File(folder2).listFiles();
		
		fillSet(root1 ,folder1 );
		fillSet(root2 , folder2);
		
		processFiles();
	}
	
	/**
	 * Processes the Set of Files
	 */
	private static void processFiles() throws IOException {
	  Iterator<String> it = unionFiles.iterator();
	  
	  while(it.hasNext())
	  {
		  String f =it.next();
		
		  File file1 = new File(folder1.concat(f));
		  File file2 = new File(folder2.concat(f));
		  if(!file1.exists() || !file2.exists())
		  {
			 
			  if(file1.exists())
				  printer(f,  "  only in " + file1.getAbsoluteFile().getParent());
			  else
				  printer(f,  "  only in " + file2.getAbsoluteFile().getParent());
		  }
		  else
		  {
			  
			 
			  StringBuilder builder1 = readFile(file1);
			  StringBuilder builder2 = readFile(file2);
			  if(builder1.toString().equals(builder2.toString()))
				printer(f, IDENTICAL);
			  else
				  printer(f, DIFFERENT);
		  }
	  }
		
	}

	//Printer Sub-routine
	public static void printer(String file , String text)
	{
		System.out.println(file + "                                     " + text);
	}

	//Fills the Set for both the fodlers
	public static void fillSet(File[] root , String folder)
	{
		for(File f : root)
		{
			if(f.isDirectory())
				fillSet(f.listFiles(),folder);
			else
				unionFiles.add(f.getAbsolutePath().substring(folder.length()));
		}
	}
	
	/**
	 * Reads the File Content
	 */
	public static StringBuilder readFile(File file1)
	{
		BufferedReader br = null;
		 StringBuilder builder = new StringBuilder("");
		try {
			String line;
			br = new BufferedReader(new FileReader(file1));
 
			while ((line = br.readLine()) != null) {
				builder.append(line);
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return builder;
	}
}
