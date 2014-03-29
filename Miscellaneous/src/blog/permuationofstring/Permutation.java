package blog.permuationofstring;

public class Permutation {
	public static void main(String[] args) {

		String text="ABC";
		Permutation obj=new Permutation();
		obj.permute(text.toCharArray(), 0, text.length() - 1);
	}

	private void permute(char[] txt , int start , int end) {

		if(start==end)
		{
			print(txt);
		}
		else {
			for(int i=start ; i<end ; i++ ) {

				permute(txt, start +1 , end) ;
				swap(txt, start, end) ;
				permute(txt, start +1 , end ) ;
			} 
		}
	}

	private void swap(char[] txt , int index1 , int index2){
		char temp=txt[index1] ;
		txt[index1] =txt [index2];
		txt[index2] = temp;
	}

	private void print(char[] txt) {
		for(int i=0;i<txt.length;i++)
			System.out.print(txt[i]);
		System.out.println();
	}

}
