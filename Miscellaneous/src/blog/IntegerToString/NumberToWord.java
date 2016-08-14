package blog.IntegerToString;

/**
 * Convert a given number to a word
 * @author PRATEEK
 */
public class NumberToWord {

	private static String ones[] = { " ", " one", " two", " three", " four",
			" five", " six", " seven", " eight", " Nine", " ten", " eleven",
			" twelve", " thirteen", " fourteen", "fifteen", " sixteen",
			" seventeen", " eighteen", " nineteen" };

	private static String tens[] = { " ", " ", " twenty", " thirty", " forty",
			" fifty", " sixty", "seventy", " eighty", " ninety" };

	
	private static void word(StringBuilder result , int val, String place) {
		if (val > 19)
			result.append(tens[val / 10] + " " + ones[val % 10]);
		else
			result.append(ones[val]);
		if (val > 0)
			result.append(place);
	}

	public static String convertToWord(int num)
	{
		if (num <= 0)
			return "";
		
		StringBuilder result = new StringBuilder("");
		word(result, num / 1000000000, " Hundred");
		word(result, (num / 10000000) % 100, " crore");
		word(result ,(num / 100000) % 100, " lakh");
		word(result, (num / 1000) % 100, " thousand");
		word(result,(num / 100) % 10, " hundred");
		word(result,num % 100, " ");
		System.out.println(num + " --> "+result.toString().trim());
		return result.toString().trim();
	}
	
	public static void main(String[] args) {
		convertToWord(117);
		convertToWord(1327);
	}
}