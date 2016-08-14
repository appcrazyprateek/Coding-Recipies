package blog.newtonraphson;

public class NewtonRaphsonInverseNumber {

	public static void main(String[] args) {
		inverse(0.2f);
		inverse(0.3f);
		inverse(3.3f);
	}

	private static float inverse(float num) {
		float x1= num,x2=0,temp=num,e=0.001f;
		do 
		{
			x1 = temp;
			x2 = x1 * (2 - num*x1);
			if(x2<0)
				x2=e;
			temp=x2;
		}while(Math.abs(x2-x1)> e);
		
		System.out.println(num + " ----> " + x2);
		return x2;
	}
}
