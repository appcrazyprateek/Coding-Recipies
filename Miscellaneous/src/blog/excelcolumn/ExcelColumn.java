package blog.excelcolumn;

/**
 * Givem a number find the excel Colomn
 * @author PRATEEK
 *
 */
public class ExcelColumn {

	private static final int EXCEL_CONSTANT = 26;

	public static void main(String[] args) {
		
		getColName(55);
		getColNum("ab");
	}

	/**
	 * Given a column Name it returns the corresponding column number
	 * @param colName
	 */
	private static int getColNum(String colName)
	{
		colName = colName.toUpperCase();
		int result  = 0;
		int len=colName.length();
		for(int i=0 ; i<len ;i++)
		{
			result *= EXCEL_CONSTANT;
			result += colName.charAt(i) - 'A' + 1;
		}
		System.out.println(colName+ "----> " + result);
		return result; 
	}
	/**
	 * Given a number it returns the corresponding column Name
	 * @param num
	 * @return
	 */
	private static String getColName(int num) {
		int temp=num;
		StringBuilder result =new StringBuilder("");
		while(num>0)
		{
			int rem = num % EXCEL_CONSTANT;
			num= num/EXCEL_CONSTANT;
			
			if(rem==0)
			{
				result.append('Z'+"");
				num--;
			}
			else
				result.append((char)(rem-1 + 'A')+"");
		}
		result =result.reverse();
		System.out.println(temp+ "----> " + result);
		return result.toString();
	}
}
