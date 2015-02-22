package com.knowlarity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class KDiff {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
	/*	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line1 = br.readLine().split(" ");
		int n= Integer.parseInt(line1[0]);
		long k= Integer.parseInt(line1[1]);
		String[] line2 = br.readLine().split(" ");
		
		long[] arr = new long[n];
		int count=0;
		for(String s:line2)
			arr[count++]=Long.parseLong(s);*/
	
		//long[] arr = {1,4,5,3,2};
		long k=1;
		long [] arr = {363374326, 364147530,61825163,1073065718,1281246024,1399469912,428047635,
				491595254,979792181,1069262793};
		kDiffPairCount(arr,k);
	}
	
	static int kDiffPairCount(long[] arr, long k)
	{
		Set<Long> hash = new HashSet<Long>();
		for(long i : arr)
			hash.add(i);
		
		int count=0;
		for(long i:arr)
		{
			long abs = i+k;//Math.abs(i-k);
			if(hash.contains(abs))
				count++;
		}
		
		System.out.println(count);
		return count;
		
	}
}
