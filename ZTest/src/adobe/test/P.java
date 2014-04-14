package adobe.test;

import java.util.*;
class P{
 public static void main(String[]a){
		long N=5,c=0,S=0,k=7,p,d,s,n; 
		
		while(c<N){
			n=k;
			//d=1;
			//  while(++d<n)if(n%d<1)p=0;
			  for(Set h=new HashSet();h.add(n);n=s)
				  for(s=0;n>0;s+=d*d,n/=10)d=n%10;	
			  
			  if(n<2){
				  System.out.println(k);
				  c++;S+=k;}
			k+=2;
		}
		System.out.print(S);
	}
}