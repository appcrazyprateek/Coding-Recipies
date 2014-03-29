package blog.scheduling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Job Definition
 * @author r.prateek
 *
 */
class Job implements Comparable<Job>
{
	int weight;
	int length;
	int difference;
	double ratio;
	
	public Job(int weight, int length)
	{
		this.weight=weight;
		this.length=length;
		this.difference=weight - length;
		this.ratio = (weight * 1.00d ) / (length * 1.00d);
	}

	// Decreasing order based on ratio, if tied then considering weight
	@Override
	public int compareTo(Job another) {
		
		int maxRatio=Double.compare(another.ratio, this.ratio);
		
		 if(maxRatio==0)
			 return another.weight - this.weight ;
		 else
			 return maxRatio;
	}
	

	// Decreasing order based on differnce, if tied then considering weight
	/*@Override
	public int compareTo(Job another) {
	
		 int diff= another.difference - this.difference ;
		
		 if(diff==0)
			 return another.weight - this.weight ;
		 else
			 return diff;
	}*/
	
	
	public String toString()
	{
		return "weight - " + weight + " || length - " + length + " || diff - " + difference + " || ratio -"+ ratio ;
	}
	
}

/**
 * Job Schedular: 1. to calculate sum of weighted completion times of the resulting schedule
 * 				  2.  schedules jobs in decreasing order of the difference (weight - length)
 * 				  3. schedules jobs in decreasing order of the ratio (weight/length)
 * @author r.prateek
 *
 */
public class Scheduling {

	int numJobs; // Number of Jobs
	static List<Job> jobList;  // List to store Jobs

	public Scheduling(int numJobs)
	{
		this.numJobs=numJobs;
		this.jobList=new ArrayList<Job>(numJobs);
	}
	
	public static void main(String[] args) throws Exception {
		helper();
	}
	
	private static void helper() throws Exception {
		  String file="jobs.txt";
		  BufferedReader br=new BufferedReader(new FileReader(new File(file)));
		  String line="";
		  int numJobs = Integer.parseInt(br.readLine());
		
		  Scheduling schedular =new Scheduling(numJobs);

		  while((line=br.readLine())!=null)
		  {
			  String temp[]=line.split(" ");
			  int weight=Integer.parseInt(temp[0]);
			  int length=Integer.parseInt(temp[1]);
			  
			  jobList.add(new Job(weight, length));
			  
		  }
		  
		  Collections.sort(jobList);
		  schedular.calculateCompletionTime();
	}
	
	
	private void calculateCompletionTime() {
		
		long completionTime=0L;
		int startTime=0;
		for(Job j: jobList)
		{	
			startTime+=j.length;
			completionTime+=j.weight * startTime;
		}
		
		System.out.println("Completion Time is : "+ completionTime);
	}
}
