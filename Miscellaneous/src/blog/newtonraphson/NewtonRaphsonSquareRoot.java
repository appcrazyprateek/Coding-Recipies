package blog.newtonraphson;
/**
 * Square root using Newton Raphson's methods
 * @author PRATEEK
 */
public class NewtonRaphsonSquareRoot {

	public static float squareRoot(float num)
	{
		float x1 = num,x2=0,temp=num,e=0.001f;
		do 
		{
			x1 = temp;
			x2 = 0.5f * (x1 + num/x1);
			temp=x2;
			
		}while(Math.abs(x2-x1)> e);
		
		System.out.println(num + " ----> " + x2);
		return x2;
	}
	
	public static void main(String[] args) {
		squareRoot(44.89f);
		squareRoot(2f);
		squareRoot(64f);
	} 
}
