package blog.wordcount;

import java.util.TreeMap;

public class FindCount {
	public static void main(String[] args) {
		//String s1="Hi Prateek hello Prateek Test String String";
		String s1="A B C Z Y X Z X M";
		String temp[]=s1.split("\\s+");

		TreeMap<ValueObject,Integer> m=new TreeMap<ValueObject,Integer>();
		for(int i=0;i<temp.length;i++)
		{
			ValueObject obj=new ValueObject(temp[i]);
			int count;

			if((m.get(obj))!=null)
				count=m.get(obj)+1;
			else
				count=1;

			m.put(obj,count);
		}
		System.out.println(m);
	}
}


class ValueObject implements Comparable
{
	String val;
	public ValueObject(String val)
	{
		this.val=val;
	}

	@Override
	public int compareTo(Object o1) {

		String s1=((ValueObject)o1).val;
		
		int comp=compareString(this.val,s1);

		return comp;
	}

	public int compareString(String s1, String s2)
	{
		char[] c1=s1.toCharArray();
		char[] c2=s2.toCharArray();

		int l1=c1.length;
		int l2=c2.length;

		int l=Math.min(l1,l2);

		for(int i=0;i<l;i++)
		{
			if(c1[i]!=c2[i])
			return c1[i] - c2[i];
		}
		return l1-l2;
	}

	@Override
	public boolean equals(Object obj) {
		if(this.val.equals(((ValueObject)obj).val))
			return true;
		return false;
	}

	@Override
	public String toString() {
		return this.val;
	}
}