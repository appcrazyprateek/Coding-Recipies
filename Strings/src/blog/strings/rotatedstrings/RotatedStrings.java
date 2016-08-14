package blog.strings.rotatedstrings;
/**
 * Check if Given strings are roated form of each other
 * @author PRATEEK
 */
public class RotatedStrings {

	public static void main(String[] args) {
		System.out.println(isRotated("coding","dingco"));
	}
	
	/**
	 * @return: true if strings are rotated form of each other
	 */
	public static boolean isRotated(String s1,String s2){
		return s1.length()==s2.length() && (s1+s1).indexOf(s2)!=-1 ;
	}
}
