package adobe.test;

import java.util.*;
class P{
 public static void main(String[]a){
  long n=new Long(a[0]),p=n>1?1:0,s,d=1;
  while(++d<n)if(n%d<1)p=0;
  for(Set c=new HashSet();c.add(n);n=s)
	  for(s=0;n>0;s+=d*d,n/=10)
		  d=n%10;
  System.out.printf("%s %sprime",n>1?"sad":"happy",p>0?"":"non-");
 }
}