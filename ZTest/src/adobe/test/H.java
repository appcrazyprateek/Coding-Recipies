package adobe.test;
import java.util.*;
class H {
	public static void main(String[]a) {
		//int n = Integer.parseInt(a[0]);
		int n=5; 
		int c=0,S=0,i=7,d,j,k;
		boolean p;
		while(c<n){
			p=true;j=3;
			Set<Integer>h=new HashSet<Integer>();
			for(;j<i/2;j+=2)
				if(i%j==0) 
					p=false;
			if(p){
				k=i;
				while(k!=1&&h.add(k)){
					j=0;
					while(k>0) {
						d=k%10;
						j+=d*d;
						k/=10;
					}
					k=j;
				}
				if(k<2){
					S+=i;c++;
					//System.out.println(i);
				}
			}
			i+=2;
		}
		System.out.print(S);
	}
}
